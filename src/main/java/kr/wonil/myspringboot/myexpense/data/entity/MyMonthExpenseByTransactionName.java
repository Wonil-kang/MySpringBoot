package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.test.myspringboot.myexpense.data.entity.pk.MyMonthlyExpenseByTransactionNamePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "monthly_expense_by_transaction_name_view")
@Data
@Subselect("select * from monthly_expense_by_transaction_name_view")
@IdClass(MyMonthlyExpenseByTransactionNamePK.class)
public class MyMonthExpenseByTransactionName implements Serializable {

    @Id
    @Column(name = "MONTH")
    private String month;
    @Id
    @Column(name = "TRANSACTION_INFO")
    private String transactionInfo;
    @Column(name = "AMT")
    private Integer amount;
    @Column(name = "AVG_1M")
    private Integer average1Month;
    @Column(name = "AVG_3M")
    private Integer average3Month;
    @Column(name = "AVG_6M")
    private Integer average6Month;
    @Column(name = "AVG_12M")
    private Integer average12Month;

}
