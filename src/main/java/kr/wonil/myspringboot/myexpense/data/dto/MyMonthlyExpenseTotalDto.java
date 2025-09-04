package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseTotal;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyMonthlyExpenseTotalDto {

    private String month;
    private Integer amount;
    private Integer exception;
    private Integer totalAmount;
    private Integer cardAmount;

    private Integer amountDayAverage;
    private Integer exceptionDayAverage;
    private Integer totalAmountDayAverage;
    private Integer cardAmountDayAverage;

    public MyMonthlyExpenseTotalDto(MyMonthlyExpenseTotal entity){
        month = entity.getMonth();
        amount = entity.getAmount();
        exception = entity.getException();
        totalAmount = entity.getTotalAmount();
        cardAmount = entity.getCardAmount();
        //cardAmount = 0;

        int daysOfMonth = DateUtil.getDaysOfMonth(month);

        amountDayAverage = (int)(double)amount/daysOfMonth;
        exceptionDayAverage = (int)(double)exception/daysOfMonth;
        totalAmountDayAverage = (int)(double)totalAmount/daysOfMonth;
        cardAmountDayAverage = (int)(double)cardAmount/daysOfMonth;

    }
}
