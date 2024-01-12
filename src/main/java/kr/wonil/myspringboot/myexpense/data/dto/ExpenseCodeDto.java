package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.ExpenseCode;
import lombok.Data;

@Data
public class ExpenseCodeDto {

    private Integer expenseCodeId;
    private String expenseCode;
    private String categoryName;
    private String codeName;
    private String recentUsedDate;
    private String useFlag;
    private String statisticFlag;

    public ExpenseCodeDto(ExpenseCode expenseCode){

        this.expenseCodeId = expenseCode.getExpenseCodeId();
        this.expenseCode = expenseCode.getExpenseCode();
        this.categoryName = expenseCode.getCategoryName();
        this.codeName = expenseCode.getCodeName();
        this.recentUsedDate = expenseCode.getRecentUsedDate();
        this.useFlag = expenseCode.getUseFlag();
        this.statisticFlag = expenseCode.getStatisticFlag();

    }

}
