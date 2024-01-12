package kr.wonil.myspringboot.myinvest.data.dao.impl;

import kr.wonil.myspringboot.myinvest.data.dao.MyStockDAO;
import kr.wonil.myspringboot.myinvest.data.entity.LastStockPrice;
import kr.wonil.myspringboot.myinvest.data.entity.MyStockHistory;
import kr.wonil.myspringboot.myinvest.data.entity.MyStockPriceFlow;
import kr.wonil.myspringboot.myinvest.data.entity.MyStockStatus;
import kr.wonil.myspringboot.myinvest.repository.LastStockPriceRepository;
import kr.wonil.myspringboot.myinvest.repository.MyStockHistoryRepository;
import kr.wonil.myspringboot.myinvest.repository.MyStockPriceFlowRepository;
import kr.wonil.myspringboot.myinvest.repository.MyStockStatusRepository;
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


    @Override
    public List<MyStockStatus> selectMyStockStatus() {

        List<MyStockStatus> myStockStatuses = myStockStatusRepository.findAll();

        return myStockStatuses;
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
}
