package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.entity.pk.MyMonthlyExpenseCodePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "MY_WEEKLY_EXPENSE_VIEW")
@Data
@IdClass(MyWeeklyExpenseTotal.class)
@Subselect("select * from MY_WEEKLY_EXPENSE_VIEW")
public class MyWeeklyExpenseTotal implements Serializable {
    @Id
    @Column(name = "year")
    private String year;
    @Id
    @Column(name = "week_number")
    private Integer weekNumber;
    @Column(name = "transaction_amount")
    private Integer transactionAmount;

}
