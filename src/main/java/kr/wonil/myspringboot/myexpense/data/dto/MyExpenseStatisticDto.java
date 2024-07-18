package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyExpenseStatistic;
import lombok.Data;

@Data
public class MyExpenseStatisticDto {

    private String expenseCode;
    private String categoryName;
    private String codeName;
    private Integer currentMonthExpense;
    private Integer averageExpense3Months;
    private Integer averageExpense6Months;
    private Integer averageExpense1Year;

    public MyExpenseStatisticDto(MyExpenseStatistic entity){
        this.expenseCode = entity.getExpenseCode();
        this.categoryName = entity.getCategoryName();
        this.codeName = entity.getCodeName();
        this.averageExpense3Months = entity.getAverageExpense3Months();
        this.averageExpense6Months = entity.getAverageExpense6Months();
        this.averageExpense1Year = entity.getAverageExpense1Year();
    }
}
