package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Entity
@Immutable
@Table(name = "MY_EXPENSE_STAT_VIEW")
@Data
@Subselect("select * from MY_EXPENSE_STAT_VIEW")
public class MyExpenseStatistic {

    @Id
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "CODE_NAME")
    private String codeName;
    @Column(name = "CUR_MON")
    private Integer currentMonthExpense;
    @Column(name = "3MON_AVG")
    private Integer averageExpense3Months;
    @Column(name = "6MON_AVG")
    private Integer averageExpense6Months;
    @Column(name = "1Y_AVG")
    private Integer averageExpense1Year;

}
