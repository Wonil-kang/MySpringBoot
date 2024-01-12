package kr.wonil.myspringboot.myexpense.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyMonthlyExpenseByCategoryPK implements Serializable {

    @Column(name = "MONTH")
    private String month;
    @Column(name = "CAT_CODE")
    private String categoryCode;
}
