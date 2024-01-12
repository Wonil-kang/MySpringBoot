package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.test.myspringboot.myexpense.data.entity.pk.MyMonthlyExpenseByExpenseCodePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "MONTHLY_EXPENSE_CODE_AMOUNT_VIEW")
@Data
@Subselect("select * from MONTHLY_EXPENSE_CODE_AMOUNT_VIEW")
@IdClass(MyMonthlyExpenseByExpenseCodePK.class)
public class MyMonthlyExpenseByExpenseCode implements Serializable {
    @Id
    @Column(name = "MONTH")
    private String month;
    @Id
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "CODE_NAME")
    private String codeName;
    @Column(name = "AMOUNT")
    private Integer amount;

}
