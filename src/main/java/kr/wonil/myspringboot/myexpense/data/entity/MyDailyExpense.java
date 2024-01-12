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
@Table(name = "my_daily_expense_view")
@Data
@Subselect("select * from my_daily_expense_view")
public class MyDailyExpense {

    @Id
    @Column(name = "date")
    private String date;
    @Column(name = "date_of_month")
    private Integer dateOfMonth;
    @Column(name = "day_of_week")
    private Integer dayOfWeek;
    @Column(name = "amount")
    private Integer expenseAmount;

}
