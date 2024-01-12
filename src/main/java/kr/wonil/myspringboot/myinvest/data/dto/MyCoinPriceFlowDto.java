package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyCoinPriceFlow;
import lombok.Data;

@Data
public class MyCoinPriceFlowDto {

    private String currency;
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

    public MyCoinPriceFlowDto(MyCoinPriceFlow myCoinPriceFlow) {

        currency = myCoinPriceFlow.getCurrency();
        timestamp = myCoinPriceFlow.getTimestamp();
        priceCurrent = myCoinPriceFlow.getPriceCurrent();
        price1DayAgo = myCoinPriceFlow.getPrice1DayAgo();
        price1WeekAgo = myCoinPriceFlow.getPrice1WeekAgo();
        price1MonthAgo = myCoinPriceFlow.getPrice1MonthAgo();
        price3MonthAgo = myCoinPriceFlow.getPrice3MonthAgo();
        priceHalfYearAgo = myCoinPriceFlow.getPriceHalfYearAgo();
        price1YearAgo = myCoinPriceFlow.getPrice1YearAgo();
        bp1DayAgo = myCoinPriceFlow.getBp1DayAgo();
        bp1WeekAgo = myCoinPriceFlow.getBp1WeekAgo();
        bp1MonthAgo = myCoinPriceFlow.getBp1MonthAgo();
        bp3MonthAgo = myCoinPriceFlow.getBp3MonthAgo();
        bpHalfYearAgo = myCoinPriceFlow.getBpHalfYearAgo();
        bp1YearAgo = myCoinPriceFlow.getBp1YearAgo();
    }
}
