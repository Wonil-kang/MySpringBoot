package kr.wonil.myspringboot.myinvest.data.dao;

import kr.wonil.myspringboot.myinvest.data.entity.*;

import java.util.List;

public interface MyStockDAO {


    public List<MyStockStatus> selectMyStockStatus();

    public List<MySPLGStatus> selectMyLastSPLGStatus();

    public List<LastStockPrice> selectLastStockPrice();

    public List<MyStockPriceFlow> selectMyStockPriceFlow();

    public List<MyStockHistory> selectMyStockHistory(int limit);

    public List<MyStockHistory> selectMyStockHistoryByStockNumber(String stockNumber, int limit);
}
