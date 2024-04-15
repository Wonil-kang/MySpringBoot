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
@Table(name = "TOTAL_FINANCE_STATUS_VIEW")
@Data
@Subselect("select * from TOTAL_FINANCE_STATUS_VIEW")
public class TotalFinanceStatus {

    @Id
    @Column(name = "TOTAL_TRADING_AMOUNT")
    private int totalTradingAmount;
    @Column(name = "ACTUAL_TRADING_AMOUNT")
    private int actualTradingAmount;
    @Column(name = "TOTAL_ESTIMATE_AMOUNT")
    private int totalEstimateAmount;
    @Column(name = "TOTAL_DIVIDEND")
    private int totalDividend;
    @Column(name = "DIVIDEND_RATE")
    private double totalDividendRate;
    @Column(name = "MARGIN_WITHOUT_DIVIDEND")
    private int marginWithDividend;
    @Column(name = "MARGIN_WITH_DIVIDEND")
    private int marginWithoutDividend;
    @Column(name = "MARGIN_RATE_WITH_DIVIDEND")
    private double marginRateWithDividend;
    @Column(name = "MARGIN_RATE_WITHOUT_DIVIDEND")
    private double marginRateWithoutDividend;

}
