package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.entity.pk.MyMonthlyExpenseCodePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "my_monthly_expense_view")
@Data
@IdClass(MyMonthlyExpenseCodePK.class)
@Subselect("select * from my_monthly_expense_view")
public class MyMonthlyExpenseCode implements Serializable {

    @Id
    @Column(name = "month")
    private String month;
    @Id
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "EXPENSE_CODE_NAME")
    private String expenseCodeName;
    @Column(name = "reflection_yn")
    private String reflectionFlag;
    @Column(name = "sum")
    private int sum;
    @Column(name = "sum_diff")
    private int sumDifference;
    @Column(name = "sum_diff_ratio")
    private double sumDifferenceRatio;
    @Column(name = "cnt")
    private int count;
    @Column(name = "cnt_diff")
    private int countDifference;
    @Column(name = "cnt_diff_ratio")
    private double countDifferenceRatio;
    @Column(name = "amt_avg")
    private int amountAverage;
    @Column(name = "amt_std")
    private int amountStandardDeviation;
    @Column(name = "amt_min")
    private int amountMinimum;
    @Column(name = "amt_max")
    private int amountMaximum;
    @Column(name = "cnt_avg")
    private int countAverage;
    @Column(name = "cnt_std")
    private int countStandardDeviation;
    @Column(name = "cnt_min")
    private int countMinimum;
    @Column(name = "cnt_max")
    private int countMaximum;

}
