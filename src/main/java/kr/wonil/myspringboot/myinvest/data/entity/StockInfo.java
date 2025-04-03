package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.data.entity.pk.MyStockPriceFlowPK;
import kr.wonil.myspringboot.myinvest.data.entity.pk.StockInfoPK;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.Data;

@Entity
@Data
@Table(name = "STOCK_INFO_TB")
@IdClass(StockInfoPK.class)
public class StockInfo {
    @Id
    @Column(name = "stock_no")
    private String stockNumber;

    @Column(name = "stock_name")
    private String stockName;

    @Column(name = "rdtt")
    private String regDateTime;

    @Column(name = "mdtt")
    private String modDateTime;

    @Column(name = "regr_id")
    private String registrantId;

    @Column(name = "modr_id")
    private String modifierId;

    @Id
    @Column(name = "stock_price_date")
    private String stockPriceDate;

    @Column(name = "etf_yn")
    private String etfYn;

    @Column(name = "stock_price")
    private Integer stockPrice;

    @Column(name = "price_difference")
    private Integer priceDifference;

    @Column(name = "price_difference_ratio")
    private Double priceDifferenceRatio;

    @Column(name = "market_value")
    private Integer marketValue;

    @Column(name = "trading_amount")
    private Integer tradingAmount;

    @Column(name = "three_month_earn_rate")
    private Double threeMonthEarnRate;

    @Column(name = "nav")
    private Double nav;

    @Column(name = "etf_type")
    private String etfType;


    public StockInfo(StockDto dto){

        stockNumber = dto.getStockNumber();
        stockName = dto.getStockName();
        regDateTime = DateUtil.getCurrentKoreanDateTimeSecond();
        modDateTime = DateUtil.getCurrentKoreanDateTimeSecond();
        registrantId = "SYS";
        modifierId = "SYS";
        stockPriceDate = dto.getStockPriceDate();
        etfYn = dto.getEtfFlag();
        stockPrice = dto.getStockPrice();
        priceDifference = dto.getDifference();
        priceDifferenceRatio = dto.getDifferenceRatio();
        marketValue = dto.getMarketValue();
        tradingAmount = dto.getTradingAmount();
        threeMonthEarnRate = dto.getThreeMonthEarnRate();
        nav = dto.getNav();
        etfType = dto.getEtfType();
    }

    public StockInfo() {

    }
}
