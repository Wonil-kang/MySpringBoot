package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.entity.pk.MyMonthlyTotalByTransactionInfoPK;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "MONTHLY_EXPENSE_BY_TRANSACTION_NAME_VIEW")
@Data
@Subselect("select * from MONTHLY_EXPENSE_BY_TRANSACTION_NAME_VIEW")
@IdClass(MyMonthlyTotalByTransactionInfoPK.class)
public class MyMonthlyTotalByTransactionInfo  implements Serializable {

    @Id
    @Column(name = "MONTH")
    private String month;
    @Id
    @Column(name = "TRANSACTION_INFO")
    private String transactionInfo;
    @Column(name = "AMT")
    private int amount;
    @Column(name = "AVG_1M")
    private int lastMonth;
    @Column(name = "AVG_3M")
    private int average3Month;
    @Column(name = "AVG_6M")
    private int average6Month;
    @Column(name = "AVG_12M")
    private int average12Month;

}
