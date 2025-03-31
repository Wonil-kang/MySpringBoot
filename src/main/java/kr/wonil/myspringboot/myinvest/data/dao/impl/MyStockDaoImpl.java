package kr.wonil.myspringboot.myinvest.data.dao.impl;

import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;
import kr.wonil.myspringboot.myinvest.data.dao.MyStockDAO;
import kr.wonil.myspringboot.myinvest.data.entity.*;
import kr.wonil.myspringboot.myinvest.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 @RequiredArgsConstructor
public class MyStockDaoImpl implements MyStockDAO {

    private final MyStockStatusRepository myStockStatusRepository;
    private final LastStockPriceRepository lastStockPriceRepository;
    private final MyStockPriceFlowRepository myStockPriceFlowRepository;
    private final MyStockHistoryRepository myStockHistoryRepository;
    private final MySPLGStatusRepository mySPLGStatusRepository;


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
}
