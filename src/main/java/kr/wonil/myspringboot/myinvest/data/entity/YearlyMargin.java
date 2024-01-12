package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.entity.pk.YearlyMarginPK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "yearly_snp_margin_view")
@Data
@IdClass(YearlyMarginPK.class)
@Subselect("select * from yearly_snp_margin_view")
public class YearlyMargin {

    //stock_no, year, init_price, cur_price, diff, diff_rate
    @Id
    @Column(name = "STOCK_NO")
    private String stockNumber;
    @Id
    @Column(name = "year")
    private String year;
    @Column(name = "init_price")
    private int initialPrice;
    @Column(name = "last_price")
    private int lastPrice;
    @Column(name = "diff")
    private int difference;
    @Column(name = "diff_rate")
    private double differenceRatio;
}
