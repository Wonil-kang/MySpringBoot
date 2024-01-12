package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "MONTHLY_INVEST_AMOUNT_VIEW")
@Data
@Subselect("select * from MONTHLY_INVEST_AMOUNT_VIEW")
public class MyMonthlyInvestTotal {

    @Id
    @Column(name = "MONTH")
    private String month;
    @Column(name = "inv_amt")
    private int investAmount;

}
