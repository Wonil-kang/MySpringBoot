package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyDailyExpense;
import lombok.Data;

@Data
public class MyDailyExpenseDto {

    private String date;
    private Integer expenseAmount;
    private Integer dateOfMonth;
    private Integer dayOfWeek;

    public MyDailyExpenseDto(MyDailyExpense entity){
        this.date = entity.getDate();
        this.expenseAmount = entity.getExpenseAmount();
        this.dateOfMonth = entity.getDateOfMonth();
        this.dayOfWeek = entity.getDayOfWeek();
    }
    
}
