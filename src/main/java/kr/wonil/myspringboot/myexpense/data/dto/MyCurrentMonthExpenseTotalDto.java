package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyCurrentMonthExpenseTotal;
import kr.wonil.myspringboot.util.DateUtil;
import kr.wonil.myspringboot.util.NumberUtil;
import lombok.Data;


@Data
public class MyCurrentMonthExpenseTotalDto {
    private String month;
    private int amount;
    private int exception;
    private int totalAmount;
    private int cardAmount;
    private int amountAverage;
    private int exceptionAverage;
    private int totalAmountAverage;
    private int cardAmountAverage;

    private int amountDiff;
    private int exceptionDiff;
    private int totalAmountDiff;
    private int cardAmountDiff;

    private double amountDiffRatio;
    private double exceptionDiffRatio;
    private double totalAmountDiffRatio;
    private double cardAmountDiffRatio;

    private int amountDayAverage;
    private int exceptionDayAverage;
    private int totalAmountDayAverage;
    private int cardAmountDayAverage;

    public MyCurrentMonthExpenseTotalDto(MyCurrentMonthExpenseTotal entity){
        month = entity.getMonth();
        amount = entity.getAmount();
        exception = entity.getException();
        totalAmount = entity.getTotalAmount();
        cardAmount = entity.getCardAmount();
        amountAverage = entity.getAmountAverage();
        exceptionAverage = entity.getExceptionAverage();
        totalAmountAverage = entity.getTotalAmountAverage();
        cardAmountAverage = entity.getCardAmountAverage();

        amountDiff = amount - amountAverage;
        exceptionDiff = exception - exceptionAverage;
        totalAmountDiff = totalAmount - totalAmountAverage;
        cardAmountDiff = cardAmount - cardAmountAverage;

        amountDiffRatio = (double)amountDiff/amountAverage * 100;
        exceptionDiffRatio = (double)exceptionDiff / exceptionAverage * 100;
        totalAmountDiffRatio = (double)totalAmountDiff / totalAmountAverage * 100;
        cardAmountDiffRatio = (double)cardAmountDiff / cardAmountAverage * 100;

        int daysOfMonth = NumberUtil.parseInt(DateUtil.getCurrentKoreanDate().substring(6,8));

        amountDayAverage = (int)(double)amount/daysOfMonth;
        exceptionDayAverage = (int)(double)exception/daysOfMonth;
        totalAmountDayAverage = (int)(double)totalAmount/daysOfMonth;
        cardAmountDayAverage = (int)(double)cardAmount/daysOfMonth;

    }

}
