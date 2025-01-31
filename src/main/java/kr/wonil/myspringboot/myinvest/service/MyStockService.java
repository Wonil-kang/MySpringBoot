package kr.wonil.myspringboot.myinvest.service;

import kr.wonil.myspringboot.myinvest.data.dto.*;

import java.util.List;

public interface MyStockService {

    public List<MyStockStatusDto> getAllMyStockStatus();
    public List<LastStockPriceDto> getLastStockPrice();
    public List<MySPLGStatusDto> getMyLastSPLGStatus();
    public List<MyStockPriceFlowDto> getMyStockPriceFlow();
    public List<MyStockHistoryDto> getMyStockHistories(int limit);
    public List<MyStockHistoryDto> getMyStockHistoriesByStockNumber(String stockNumber, int limit);

}
