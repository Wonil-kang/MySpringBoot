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
@Table(name = "MY_INVEST_TOTAL_STATUS_VIEW")
@Data
@Subselect("select * from MY_INVEST_TOTAL_STATUS_VIEW")
public class MyInvestTotalStatus {

    @Id
    @Column(name = "TODAY")
    private String today;
    @Column(name = "TOTAL_TRADING_AMOUNT")
    private Integer totalTradingAmount;
    @Column(name = "ACTUAL_TRADING_AMOUNT")
    private Integer actualTradingAmount;
    @Column(name = "TOTAL_ESTIMATE_AMOUNT")
    private Integer totalEstimateAmount;
    @Column(name = "TOTAL_DIVIDEND")
    private Integer totalDividend;
    @Column(name = "DIVIDEND_RATE")
    private Double totalDividendRate;
    @Column(name = "MARGIN_WITHOUT_DIVIDEND")
    private Integer marginWithoutDividend;
    @Column(name = "MARGIN_RATE_WITHOUT_DIVIDEND")
    private Double marginRateWithoutDividend;
    @Column(name = "MARGIN_WITH_DIVIDEND")
    private Integer marginWithDividend;
    @Column(name = "MARGIN_RATE_WITH_DIVIDEND")
    private Double marginRateWithDividend;

}
