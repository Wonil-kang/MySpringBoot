package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseByExpenseCode;
import lombok.Data;

@Data
public class MyMonthlyExpenseByExpenseCodeDto {
    private String month;
    private String expenseCode;
    private String categoryName;
    private String codeName;
    private Integer amount;

    public MyMonthlyExpenseByExpenseCodeDto(MyMonthlyExpenseByExpenseCode entity){

        this.month = entity.getMonth();
        this.expenseCode = entity.getExpenseCode();
        this.categoryName = entity.getCategoryName();
        this.codeName = entity.getCodeName();
        this.amount = entity.getAmount();

    }
}
