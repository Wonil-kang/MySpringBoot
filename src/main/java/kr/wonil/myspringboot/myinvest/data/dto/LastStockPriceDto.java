package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.LastStockPrice;
import lombok.Data;

@Data
public class LastStockPriceDto {
    private String stockNumber;
    private String stockName;
    private int stockPrice;
    private int lastStockPrice;
    private int difference;
    private double differenceRatio;
    private double percentile;

    public LastStockPriceDto(LastStockPrice lastStockPrice) {

        this.stockNumber = lastStockPrice.getStockNumber();
        this.stockName = lastStockPrice.getStockName();
        this.stockPrice = lastStockPrice.getStockPrice();
        this.lastStockPrice = lastStockPrice.getLastStockPrice();
        this.difference = lastStockPrice.getDifference();
        this.differenceRatio = lastStockPrice.getDifferenceRatio();
        this.percentile = lastStockPrice.getPercentile();
    }

}
