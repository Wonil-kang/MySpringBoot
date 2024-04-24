package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.entity.pk.SnPYoYPK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "SNP_PRICE_TO_TOP_VIEW")
@Data
@Subselect("select * from SNP_PRICE_TO_TOP_VIEW")
public class SnpPriceToTop {

    @Id
    @Column(name = "max_price")
    private Integer maxPrice;
    @Column(name = "cur_pirce")
    private Integer currentPrice;
    @Column(name = "diff")
    private Integer difference;
    @Column(name = "diff_ratio")
    private Double differenceRatio;

}
