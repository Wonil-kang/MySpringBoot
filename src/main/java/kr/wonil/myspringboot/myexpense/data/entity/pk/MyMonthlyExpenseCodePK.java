package kr.wonil.myspringboot.myexpense.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyMonthlyExpenseCodePK implements Serializable {

    @Column(name = "month")
    private String month;
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
}
