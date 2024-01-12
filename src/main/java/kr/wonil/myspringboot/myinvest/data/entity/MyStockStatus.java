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
@Table(name = "my_stock_status_tb")
@Data
@Subselect("select * from my_stock_status_tb where stock_price_date = (SELECT max(stock_price_date) from my_stock_status_tb)")
public class MyStockStatus {

    @Id
    @Column(name = "STOCK_NO")
    private String stockNumber;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "STOCK_PRICE_DATE")
    private String stockPriceDate;
    @Column(name = "STOCK_PRICE")
    private String stockPrice;
    @Column(name = "PECENTILE")
    private String percentile;
    @Column(name = "PRICE_DIFFERENCE")
    private String priceDifference;
    @Column(name = "PRICE_DIFFERENCE_RATIO")
    private String priceDifferenceRatio;
    @Column(name = "NUMBER_OF_STOCK")
    private String numberOfStock;
    @Column(name = "TOTAL_TRADING_AMOUNT")
    private String totalTradingAmount;
    @Column(name = "TOTAL_ESTIMATE_AMOUNT")
    private String totalEstimateAmount;
    @Column(name = "AVG_TRADING_PRICE")
    private String averageTradingPrice;
    @Column(name = "MARGIN")
    private String margin;
    @Column(name = "MARGIN_RATE")
    private String marginRate;
    @Column(name = "UPDATE_TIME")
    private String updateTime;


}
