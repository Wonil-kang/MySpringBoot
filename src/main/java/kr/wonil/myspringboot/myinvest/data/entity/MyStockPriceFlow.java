package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.entity.pk.MyStockPriceFlowPK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Data
@Table(name = "MY_STOCK_PRICE_FLOW_TB")
@IdClass(MyStockPriceFlowPK.class)
@Subselect("select * from MY_STOCK_PRICE_FLOW_TB " +
        "WHERE timestamp  = (SELECT MAX(timestamp) FROM MY_STOCK_PRICE_FLOW_TB )")
public class MyStockPriceFlow {

    @Id
    @Column(name = "stock_no")
    private String stockNumber;
    @Column(name = "stock_name")
    private String stockName;
    @Id
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "current_price")
    private int priceCurrent;
    @Column(name = "1d_ago_price")
    private int price1DayAgo;
    @Column(name = "1w_ago_price")
    private int price1WeekAgo;
    @Column(name = "1m_ago_price")
    private int price1MonthAgo;
    @Column(name = "3m_ago_price")
    private int price3MonthAgo;
    @Column(name = "hy_ago_price")
    private int priceHalfYearAgo;
    @Column(name = "1y_ago_price")
    private int price1YearAgo;
    @Column(name = "1d_ago_bp")
    private int bp1DayAgo;
    @Column(name = "1w_ago_bp")
    private int bp1WeekAgo;
    @Column(name = "1m_ago_bp")
    private int bp1MonthAgo;
    @Column(name = "3m_ago_bp")
    private int bp3MonthAgo;
    @Column(name = "hy_ago_bp")
    private int bpHalfYearAgo;
    @Column(name = "1y_ago_bp")
    private int bp1YearAgo;

}
