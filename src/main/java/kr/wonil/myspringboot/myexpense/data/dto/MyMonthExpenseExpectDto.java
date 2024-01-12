package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthExpenseExpect;
import lombok.Data;

@Data
public class MyMonthExpenseExpectDto {

    private Integer todayAmount;
    private Integer thisWeekAmount;
    private Integer thisMonthExpectedAmount;
    private Integer maxAverageExpense;
    private Integer targetExpenseWithFixedExpense;
    private Integer fixedExpense;
    public MyMonthExpenseExpectDto(MyMonthExpenseExpect entity){

        this.todayAmount = entity.getTodayAmount();
        this.thisWeekAmount = entity.getThisWeekAmount();
        this.thisMonthExpectedAmount = entity.getThisMonthExpectedAmount();
        this.maxAverageExpense = entity.getMaxAverageExpense();
        this.fixedExpense = entity.getFixedExpense();
        this.targetExpenseWithFixedExpense = entity.getTargetExpenseWithFixedExpense();

    }

}
