package kr.wonil.myspringboot.myinvest.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.myspringboot.myinvest.data.entity.MySPLGStatus;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
public class MySPLGStatusDto {

    private String stockNumber;
    private String stockName;
    private String stockPriceDate;
    private double stockPrice;
    private double fxRate;
    private double percentile;
    private double priceToTopRatio;
    private double priceDifference;
    private double priceDifferenceRatio;
    private int numberOfStock;
    private double totalTradingAmount;
    private double totalEstimateAmount;
    private double averageTradingPrice;
    private double margin;
    private double marginRate;
    private int totalTradingAmountKR;
    private int totalEstimateAmountKR;
    private int marginKR;

    public MySPLGStatusDto(MySPLGStatus entity) {

        this.stockNumber = entity.getStockNumber();
        this.stockName = entity.getStockName();
        this.stockPriceDate = entity.getStockPriceDate();
        this.stockPrice = entity.getStockPrice();
        this.fxRate = entity.getFxRate();
        this.percentile = entity.getPercentile();
        this.priceToTopRatio = entity.getPriceToTopRatio();
        this.priceDifference = entity.getPriceDifference();
        this.priceDifferenceRatio = entity.getPriceDifferenceRatio();
        this.numberOfStock = entity.getNumberOfStock();
        this.totalTradingAmount = entity.getTotalTradingAmount();
        this.totalEstimateAmount = entity.getTotalEstimateAmount();
        this.averageTradingPrice = entity.getAverageTradingPrice();
        this.margin = entity.getMargin();
        this.marginRate = entity.getMarginRate();
        this.totalTradingAmountKR = entity.getTotalTradingAmountKR();
        this.totalEstimateAmountKR = entity.getTotalEstimateAmountKR();
        this.marginKR = entity.getMarginKR();

    }


}
