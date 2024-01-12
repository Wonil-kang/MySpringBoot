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
@Table(name = "my_last_stock_price_view")
@Data
@Subselect("select * from my_last_stock_price_view")
public class LastStockPrice {

    @Id
    @Column(name = "STOCK_NO")
    private String stockNumber;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "STOCK_PRICE")
    private int stockPrice;
    @Column(name = "LAST_STOCK_PRICE")
    private int lastStockPrice;
    @Column(name = "DIFF")
    private int difference;
    @Column(name = "DIFF_RATIO")
    private double differenceRatio;
    @Column(name = "PERCENTILE")
    private double percentile;

}
