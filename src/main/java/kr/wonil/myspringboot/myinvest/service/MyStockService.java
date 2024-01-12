package kr.wonil.myspringboot.myinvest.service;

import kr.wonil.test.myspringboot.myinvest.data.dto.LastStockPriceDto;
import kr.wonil.test.myspringboot.myinvest.data.dto.MyStockHistoryDto;
import kr.wonil.test.myspringboot.myinvest.data.dto.MyStockPriceFlowDto;
import kr.wonil.test.myspringboot.myinvest.data.dto.MyStockStatusDto;

import java.util.List;

public interface MyStockService {

    public List<MyStockStatusDto> getAllMyStockStatus();
    public List<LastStockPriceDto> getLastStockPrice();
    public List<MyStockPriceFlowDto> getMyStockPriceFlow();
    public List<MyStockHistoryDto> getMyStockHistories(int limit);
    public List<MyStockHistoryDto> getMyStockHistoriesByStockNumber(String stockNumber, int limit);

}
