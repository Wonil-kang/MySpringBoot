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
@Table(name = "PRICE_TO_TOP_VIEW")
@Data
@Subselect("select * from PRICE_TO_TOP_VIEW")
public class PriceToTop {

    @Id
    @Column(name = "stock_no")
    private String stockNumber;
    @Column(name = "max_price")
    private Integer maxPrice;
    @Column(name = "cur_pirce")
    private Integer currentPrice;
    @Column(name = "diff")
    private Integer difference;
    @Column(name = "diff_ratio")
    private Double differenceRatio;

}
