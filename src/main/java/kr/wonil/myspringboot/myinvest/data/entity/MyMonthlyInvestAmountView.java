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
@Table(name = "MONTHLY_INVEST_AMOUNT_VIEW")
@Data
@Subselect("select * from MONTHLY_INVEST_AMOUNT_VIEW")
public class MyMonthlyInvestAmountView {

    @Id
    @Column(name = "MONTH")
    private String month;
    @Column(name = "inv_amt")
    private int amount;
    @Column(name = "AVG_1M")
    private int lastMonth;
    @Column(name = "AVG_3M")
    private int average3Month;
    @Column(name = "AVG_6M")
    private int average6Month;
    @Column(name = "AVG_12M")
    private int average12Month;

}
