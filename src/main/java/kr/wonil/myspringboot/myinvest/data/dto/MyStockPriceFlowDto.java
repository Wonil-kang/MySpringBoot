package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyStockPriceFlow;
import lombok.Data;

@Data
public class MyStockPriceFlowDto {

    private String stockNumber;
    private String stockName;
    private String timestamp;
    private int priceCurrent;
    private int price1DayAgo;
    private int price1WeekAgo;
    private int price1MonthAgo;
    private int price3MonthAgo;
    private int priceHalfYearAgo;
    private int price1YearAgo;
    private int bp1DayAgo;
    private int bp1WeekAgo;
    private int bp1MonthAgo;
    private int bp3MonthAgo;
    private int bpHalfYearAgo;
    private int bp1YearAgo;

    public MyStockPriceFlowDto(MyStockPriceFlow myStockPriceFlow) {

        stockNumber = myStockPriceFlow.getStockNumber();
        stockName = myStockPriceFlow.getStockName();
        timestamp = myStockPriceFlow.getTimestamp();
        priceCurrent = myStockPriceFlow.getPriceCurrent();
        price1DayAgo = myStockPriceFlow.getPrice1DayAgo();
        price1WeekAgo = myStockPriceFlow.getPrice1WeekAgo();
        price1MonthAgo = myStockPriceFlow.getPrice1MonthAgo();
        price3MonthAgo = myStockPriceFlow.getPrice3MonthAgo();
        priceHalfYearAgo = myStockPriceFlow.getPriceHalfYearAgo();
        price1YearAgo = myStockPriceFlow.getPrice1YearAgo();
        bp1DayAgo = myStockPriceFlow.getBp1DayAgo();
        bp1WeekAgo = myStockPriceFlow.getBp1WeekAgo();
        bp1MonthAgo = myStockPriceFlow.getBp1MonthAgo();
        bp3MonthAgo = myStockPriceFlow.getBp3MonthAgo();
        bpHalfYearAgo = myStockPriceFlow.getBpHalfYearAgo();
        bp1YearAgo = myStockPriceFlow.getBp1YearAgo();
    }
}
