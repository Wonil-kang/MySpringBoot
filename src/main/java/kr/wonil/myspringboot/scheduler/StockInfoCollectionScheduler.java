package kr.wonil.myspringboot.scheduler;
import jakarta.persistence.EntityManager;
import kr.wonil.myspringboot.Crawler.StockCrawler;
import kr.wonil.myspringboot.Crawler.StockCrawlerETF;
import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.service.MyStockService;
import kr.wonil.myspringboot.mymanage.service.HolidayService;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    // 매일 새벽 2시에 실행
    @Scheduled(cron = "0 0 2 * * ?")
    public void runDaily() {
        // log.info("매일 새벽 2시 작업 실행");
        // 작업 내용
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
}
