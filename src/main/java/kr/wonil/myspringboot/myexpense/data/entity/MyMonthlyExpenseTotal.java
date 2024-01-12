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
@Table(name = "my_monthly_expense_total_view")
@Data
@Subselect("select * from my_monthly_expense_total_view")
public class MyMonthlyExpenseTotal {

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

    public void setZero(){
        amount= 0;
        exception = 0;
        totalAmount = 0;
        cardAmount = 0;
    }
}
