package kr.wonil.myspringboot.scheduler;
import jakarta.persistence.EntityManager;
import kr.wonil.myspringboot.Crawler.StockCrawler;
import kr.wonil.myspringboot.Crawler.StockCrawlerETF;
import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.service.MyStockService;
import kr.wonil.myspringboot.mymanage.service.HolidayService;
import kr.wonil.myspringboot.util.DateUtil;
import kr.wonil.myspringboot.util.NumberUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockInfoCollectionScheduler {

    private final HolidayService holidayService;
    private final MyStockService mystockService;
    private final EntityManager entityManager;

    // 매 5분마다 실행
    @Scheduled(cron = "0 */10 * * * ?")
    public void collectStockInfo() {
        log.info("* * * START STOCK INFO COLLECTION SCHEDULER(" + DateUtil.getReadableDate(DateUtil.getCurrentKoreanDateTimeSecond(), "YYYY.MM.DD. HH:mm:SS") + ") * * *");
        // 작업 내용

        String date = DateUtil.getCurrentKoreanDate();
        ArrayList<StockDto> stocks;

        if( holidayService.isHoliday(date)) {

            System.out.println("STOCK INFO SCHEDULER: TODAY IS A HOLIDAY");

            return;

        }

        if( DateUtil.isKoreanWeekend() ) {

            System.out.println("STOCK INFO SCHEDULER: TODAY IS A WEEKEND");
            return;
        }

        // stocks = StockCrawler.getStockInfo();
        // updateStocks(stocks, false);

        stocks = StockCrawlerETF.getETFInfo();
        updateStocks(stocks, true);

        try {

            entityManager.createStoredProcedureQuery("PRC_UPDATE_MY_STOCK_STATUS").execute();
            entityManager.createStoredProcedureQuery("PRC_UPDATE_MY_STOCK_PRICE_FLOW").execute();

        }catch (Exception ex) {
            log.error("Failed to execute my stock procedure", ex);
            throw ex; // 트랜잭션 유지하려면 다시 던져야 함
        }



        log.info("* * * FINISH STOCK INFO COLLECTION SCHEDULER(" + DateUtil.getReadableDate(DateUtil.getCurrentKoreanDateTimeSecond(), "YYYY.MM.DD. HH:mm:SS") + ") * * *");
    }


    public void updateStocks(ArrayList<StockDto> stocks, boolean etfFlag) {

        ArrayList<StockDto> temp = null;
        StockDto s = null;
        String logStr = null;
        String today = DateUtil.getCurrentKoreanDate();

        if (stocks == null) return;

        for(int i=0; i < stocks.size(); i++) {

            s = stocks.get(i);

            s.setStockPriceDate(today);

            mystockService.insertOrUpdateStockInfo(s);
        }

        if(etfFlag) {
            logStr = "  - FINISH STOCK-ETF CRAWLING";
            log.info(logStr);
        }else {
            logStr = "  - FINISH STOCK-NONETF CRAWLING";
            System.out.println(logStr);
        }

    }


    // 30분마다 실행
    @Scheduled(cron = "0 0/30 * * * ?")
    public void runYahooCrawlerBatch() {
        try {
            // .bat 파일 경로를 큰따옴표로 감싸서 공백/한글 경로 문제 방지
            String batchFilePath = "C:\\Users\\wikang\\Dropbox\\000.스크립트\\02.Yahoo_Crawler.bat";
            File batchFile = new File(batchFilePath);

            // ✅ 파일 존재 여부 체크
            if (!batchFile.exists()) {
                log.debug("[SKIP] Yahoo 크롤러 실행 파일이 존재하지 않습니다: {}", batchFilePath);
                return; // 조용히 종료
            }

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batchFilePath);
            processBuilder.inheritIO(); // 콘솔 출력 보기 원할 경우
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            System.out.println("Yahoo 크롤러 실행 완료! 종료 코드: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Yahoo 크롤러 실행 중 오류 발생:");
            e.printStackTrace();
            log.error(e.toString());
        }
    }
}
