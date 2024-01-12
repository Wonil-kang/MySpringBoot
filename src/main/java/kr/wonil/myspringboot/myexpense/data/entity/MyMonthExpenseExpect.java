package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "MY_MONTH_EXPENSE_EXPECT_VIEW")
@Data
@Subselect("select * from MY_MONTH_EXPENSE_EXPECT_VIEW")
public class MyMonthExpenseExpect {
    @Id
    @Column(name = "TODAY_AMT")
    private Integer todayAmount;
    @Column(name = "THIS_WEEK_AMT")
    private Integer thisWeekAmount;
    @Column(name = "THIS_MONTH_AMT_EXP")
    private Integer thisMonthExpectedAmount;
    @Column(name = "MAX_AVG_EXPENSE")
    private Integer maxAverageExpense;
    @Column(name = "FIXED_EXPENSE")
    private Integer fixedExpense;
    @Column(name = "TARGET_EXPENSE_WITH_FIXED_EXPENSE")
    private Integer targetExpenseWithFixedExpense;

}
