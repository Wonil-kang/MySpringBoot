package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyExpenseCode;
import lombok.Data;


@Data
public class MyMonthlyExpenseCodeDto {

    private String month;
    private String expenseCode;
    private String categoryName;
    private String expenseCodeName;
    private String reflectionFlag;
    private int sum;
    private int sumDifference;
    private double sumDifferenceRatio;
    private int count;
    private int countDifference;
    private double countDifferenceRatio;
    private int amountAverage;
    private int amountStandardDeviation;
    private int amountMinimum;
    private int amountMaximum;
    private int countAverage;
    private int countStandardDeviation;
    private int countMinimum;
    private int countMaximum;

    public MyMonthlyExpenseCodeDto(MyMonthlyExpenseCode myMonthlyExpenseCode) {

        month = myMonthlyExpenseCode.getMonth();
        expenseCode = myMonthlyExpenseCode.getExpenseCode();
        categoryName = myMonthlyExpenseCode.getCategoryName();
        expenseCodeName = myMonthlyExpenseCode.getExpenseCodeName();
        reflectionFlag = myMonthlyExpenseCode.getReflectionFlag();
        sum = myMonthlyExpenseCode.getSum();
        sumDifference = myMonthlyExpenseCode.getSumDifference();
        sumDifferenceRatio = myMonthlyExpenseCode.getSumDifferenceRatio();
        count = myMonthlyExpenseCode.getCount();
        countDifference = myMonthlyExpenseCode.getCountDifference();
        countDifferenceRatio = myMonthlyExpenseCode.getCountDifferenceRatio();
        amountAverage = myMonthlyExpenseCode.getAmountAverage();
        amountStandardDeviation = myMonthlyExpenseCode.getAmountStandardDeviation();
        amountMinimum = myMonthlyExpenseCode.getAmountMinimum();
        amountMaximum = myMonthlyExpenseCode.getAmountMaximum();
        countAverage = myMonthlyExpenseCode.getCountAverage();
        countStandardDeviation = myMonthlyExpenseCode.getCountStandardDeviation();
        countMinimum = myMonthlyExpenseCode.getCountMinimum();
        countMaximum = myMonthlyExpenseCode.getCountMaximum();
    }
}
