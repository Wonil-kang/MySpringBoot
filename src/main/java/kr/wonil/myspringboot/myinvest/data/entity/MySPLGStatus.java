package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "MY_SPLG_STATUS_VIEW")
@Data
@Subselect("select * from MY_SPLG_STATUS_VIEW")
public class MySPLGStatus {


    @Column(name = "STOCK_NO")
    private String stockNumber;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Id
    @Column(name = "STOCK_PRICE_DATE")
    private String stockPriceDate;
    @Column(name = "STOCK_PRICE")
    private double stockPrice;
    @Column(name = "FX_RATE")
    private double fxRate;
    @Column(name = "PECENTILE")
    private double percentile;
    @Column(name = "PRICE_DIFFERENCE")
    private double priceDifference;
    @Column(name = "PRICE_DIFFERENCE_RATIO")
    private double priceDifferenceRatio;
    @Column(name = "NUMBER_OF_STOCK")
    private int numberOfStock;
    @Column(name = "TOTAL_TRADING_AMOUNT")
    private double totalTradingAmount;
    @Column(name = "TOTAL_ESTIMATE_AMOUNT")
    private double totalEstimateAmount;
    @Column(name = "AVG_TRADING_PRICE")
    private double averageTradingPrice;
    @Column(name = "MARGIN")
    private double margin;
    @Column(name = "MARGIN_RATE")
    private double marginRate;
    @Column(name = "TOTAL_TRADING_AMOUNT_KR")
    private int totalTradingAmountKR;
    @Column(name = "TOTAL_ESTIMATE_AMOUNT_KR")
    private int totalEstimateAmountKR;
    @Column(name = "MARGIN_KR")
    private int marginKR;
}
