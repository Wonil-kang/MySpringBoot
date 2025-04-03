package kr.wonil.myspringboot.myinvest.data.dao;

import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.data.entity.*;

import java.util.List;

public interface MyStockDAO {


    public List<MyStockStatus> selectMyStockStatus();

    public List<MySPLGStatus> selectMyLastSPLGStatus();

    public List<LastStockPrice> selectLastStockPrice();

    public List<MyStockPriceFlow> selectMyStockPriceFlow();

    public List<MyStockHistory> selectMyStockHistory(int limit);

    public List<MyStockHistory> selectMyStockHistoryByStockNumber(String stockNumber, int limit);

    public MyStockHistory insertMyStockHistory(MyStockHistory myStockHistory);

    public StockInfo selectStockInfoByKey(StockDto stockDto);

    public StockInfo insertStockInfo(StockInfo stockInfo);

    public int updateStockInfo(StockInfo stockInfo);

}
