package kr.wonil.myspringboot.myexpense.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyMonthlyTotalByTransactionInfoPK implements Serializable {

    @Column(name = "month")
    private String month;
    @Column(name = "TRANSACTION_INFO")
    private String transactionInfo;
}
