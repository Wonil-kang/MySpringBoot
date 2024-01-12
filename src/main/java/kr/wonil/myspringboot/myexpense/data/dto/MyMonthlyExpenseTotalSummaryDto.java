package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyExpenseTotal;
import lombok.Data;

@Data
public class MyMonthlyExpenseTotalSummaryDto {

    private String currentMonth;
    private String previousMonth;
    private Integer currentAmount;
    private Integer currentException;
    private Integer currentTotalAmount;
    private Integer previousAmount;
    private Integer previousException;
    private Integer previousTotalAmount;
    private Integer amountDifference;
    private Integer exceptionDifference;
    private Integer totalAmountDifference;
    private Double amountDifferenceRatio;
    private Double exceptionDifferenceRatio;
    private Double totalAmountDifferenceRatio;


    public MyMonthlyExpenseTotalSummaryDto(
            MyMonthlyExpenseTotal current,
            MyMonthlyExpenseTotal previous ){


        currentMonth = current.getMonth();
        previousMonth = previous.getMonth();
        currentAmount = current.getAmount();
        currentException = current.getException();
        currentTotalAmount = current.getTotalAmount();
        previousAmount = previous.getAmount();
        previousException = previous.getException();
        previousTotalAmount = previous.getTotalAmount();
        amountDifference = currentAmount - previousAmount;
        exceptionDifference = currentException - previousException;
        totalAmountDifference = currentTotalAmount - previousTotalAmount;

        if(previousAmount == 0)
            amountDifferenceRatio = 0.0;
        else
            amountDifferenceRatio = amountDifference / (double) previousAmount * 100;

        if(previousException == 0)
            exceptionDifferenceRatio = 0.0;
        else
            exceptionDifferenceRatio = exceptionDifference / (double) previousException * 100;

        if(previousTotalAmount == 0)
            totalAmountDifferenceRatio = 0.0;
        else
            totalAmountDifferenceRatio = totalAmountDifference / (double) previousTotalAmount * 100;

    }
}
