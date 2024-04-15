package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyStockStatus;
import lombok.Data;

@Data
public class MyStockStatusDto {

    private String stockNumber;
    private String stockName;
    private String stockPrice;
    private String stockPriceDate;
    private String percentile;
    private String priceDifference;
    private String priceDifferenceRatio;
    private String numberOfStock;
    private String totalTradingAmount;
    private String totalEstimateAmount;
    private String averageTradingPrice;
    private String margin;
    private String marginRate;
    private String updateTime;

    public MyStockStatusDto(MyStockStatus myStockStatus) {

        stockNumber = myStockStatus.getStockNumber();
        stockName = myStockStatus.getStockName();
        stockPrice = myStockStatus.getStockPrice();
        stockPriceDate = myStockStatus.getStockPriceDate();
        percentile = myStockStatus.getPercentile();
        priceDifference = myStockStatus.getPriceDifference();
        priceDifferenceRatio = myStockStatus.getPriceDifferenceRatio();
        numberOfStock = myStockStatus.getNumberOfStock();
        totalTradingAmount = myStockStatus.getTotalTradingAmount();
        totalEstimateAmount = myStockStatus.getTotalEstimateAmount();
        averageTradingPrice = myStockStatus.getAverageTradingPrice();
        margin = myStockStatus.getMargin();
        marginRate = myStockStatus.getMarginRate();
        updateTime = myStockStatus.getUpdateTime();
    }
}
