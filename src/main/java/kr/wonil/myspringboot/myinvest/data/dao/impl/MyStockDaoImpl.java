package kr.wonil.myspringboot.myinvest.data.dao.impl;

import kr.wonil.myspringboot.myinvest.data.dao.MyStockDAO;
import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.data.entity.*;
import kr.wonil.myspringboot.myinvest.data.entity.pk.StockInfoPK;
import kr.wonil.myspringboot.myinvest.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
 @RequiredArgsConstructor
public class MyStockDaoImpl implements MyStockDAO {

    private final MyStockStatusRepository myStockStatusRepository;
    private final LastStockPriceRepository lastStockPriceRepository;
    private final MyStockPriceFlowRepository myStockPriceFlowRepository;
    private final MyStockHistoryRepository myStockHistoryRepository;
    private final MySPLGStatusRepository mySPLGStatusRepository;
    private final StockInfoRepository   stockInfoRepository;


    @Override
    public List<MyStockStatus> selectMyStockStatus() {

        List<MyStockStatus> myStockStatuses = myStockStatusRepository.findAll();

        return myStockStatuses;
    }

    @Override
    public List<MySPLGStatus> selectMyLastSPLGStatus() {
        return mySPLGStatusRepository.findLastData();
    }

    @Override
    public List<LastStockPrice> selectLastStockPrice() {

        List<LastStockPrice> list = lastStockPriceRepository.findAll();
        return list;
    }

    @Override
    public List<MyStockPriceFlow> selectMyStockPriceFlow() {
        List<MyStockPriceFlow> list = myStockPriceFlowRepository.findAll();
        return list;
    }

    @Override
    public List<MyStockHistory> selectMyStockHistory(int limit) {

        Page<MyStockHistory> page = myStockHistoryRepository.findMyStockHistories(PageRequest.of(0,limit));

        return page.getContent();
    }

    @Override
    public List<MyStockHistory> selectMyStockHistoryByStockNumber(String stockNumber, int limit) {

        Page<MyStockHistory> page = myStockHistoryRepository.findMyStockHistoriesByStockNumber(stockNumber, PageRequest.of(0, limit));

        return page.getContent();
    }




    @Override
    public MyStockHistory insertMyStockHistory(MyStockHistory myStockHistory) {

        MyStockHistory result = null;

        try {

            result = myStockHistoryRepository.save(myStockHistory);

        }catch(Exception e){

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public StockInfo selectStockInfoByKey(StockDto stockDto) {

        Optional<StockInfo> result = null;

        try {

            StockInfoPK pk = new StockInfoPK();
            pk.setStockNumber(stockDto.getStockNumber());
            pk.setStockPriceDate(stockDto.getStockPriceDate());

            result = stockInfoRepository.findById(pk);

            if(result.isPresent()) {

                return result.get();
            }


        }catch(Exception e){

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public StockInfo insertStockInfo(StockInfo stockInfo) {

        StockInfo result = null;

        try {

            result = stockInfoRepository.save(stockInfo);

        }catch(Exception e){

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateStockInfo(StockInfo stockInfo) {

        int result = -1;

        try {

            result = stockInfoRepository.updateStockInfo (
                    stockInfo.getStockNumber(),
                    stockInfo.getStockPriceDate(),
                    stockInfo.getStockName(),
                    stockInfo.getRegDateTime(),
                    stockInfo.getModDateTime(),
                    stockInfo.getRegistrantId(),
                    stockInfo.getModifierId(),
                    stockInfo.getEtfYn(),
                    stockInfo.getStockPrice(),
                    stockInfo.getPriceDifference(),
                    stockInfo.getPriceDifferenceRatio(),
                    stockInfo.getMarketValue(),
                    stockInfo.getTradingAmount(),
                    stockInfo.getThreeMonthEarnRate(),
                    stockInfo.getNav(),
                    stockInfo.getEtfType()
            );

        }catch(Exception e){

            e.printStackTrace();
        }

        return result;
    }
}
