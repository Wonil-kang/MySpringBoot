package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.test.myspringboot.myinvest.data.entity.pk.DividendRatePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Data
@Table(name = "dividend_rate_view")
@IdClass(DividendRatePK.class)
@Subselect("select * from dividend_rate_view")
public class DividendRate {

    @Id
    @Column(name = "stock_no")
    private String stockNumber;
    @Column(name = "stock_name")
    private String stockName;
    @Id
    @Column(name = "year")
    private String year;
    @Column(name = "dividend")
    private int dividend;
    @Column(name = "stock_price")
    private int currentStockPrice;
    @Column(name = "avg_stock_price")
    private int averageStockPrice;
    @Column(name = "dividend_rate")
    private double currentDividendRate;
    @Column(name = "my_dividen_rate")
    private double myDividendRate;

}
