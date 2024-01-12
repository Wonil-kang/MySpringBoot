package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.entity.pk.MyMonthlyExpenseByCategoryPK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "MONTHLY_EXPENSE_CAT_CODE_AMOUNT_VIEW")
@Data
@Subselect("select * from MONTHLY_EXPENSE_CAT_CODE_AMOUNT_VIEW")
@IdClass(MyMonthlyExpenseByCategoryPK.class)
public class MyMonthlyExpenseByCategory implements Serializable {
    @Id
    @Column(name = "MONTH")
    private String month;
    @Id
    @Column(name = "CAT_CODE")
    private String categoryCode;
    @Column(name = "CAT_NAME")
    private String categoryName;
    @Column(name = "AMOUNT")
    private Integer amount;
}
