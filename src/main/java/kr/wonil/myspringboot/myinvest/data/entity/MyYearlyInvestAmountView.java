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
@Table(name = "YEARLY_INVEST_AMOUNT_VIEW")
@Data
@Subselect("select * from YEARLY_INVEST_AMOUNT_VIEW")
public class MyYearlyInvestAmountView {

    @Id
    @Column(name = "year")
    private String year;
    @Column(name = "inv_amt")
    private int amount;

}
