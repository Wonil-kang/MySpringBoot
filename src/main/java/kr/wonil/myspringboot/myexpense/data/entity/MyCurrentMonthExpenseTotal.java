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
@Table(name = "MY_CURRENT_EXPENSE_STAT_VIEW")
@Data
@Subselect("select * from MY_CURRENT_EXPENSE_STAT_VIEW")
public class MyCurrentMonthExpenseTotal {
    @Id
    @Column(name = "month")
    private String month;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "exception")
    private Integer exception;
    @Column(name = "total_amount")
    private Integer totalAmount;
    @Column(name = "card")
    private Integer cardAmount;
    @Column(name = "ACTUAL_AVG")
    private Integer amountAverage;
    @Column(name = "EXCEPTION_AVG")
    private Integer exceptionAverage;
    @Column(name = "TOTAL_AVG")
    private Integer totalAmountAverage;
    @Column(name = "CARD_AVG")
    private Integer cardAmountAverage;

}
