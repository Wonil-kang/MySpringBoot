package kr.wonil.myspringboot.myexpense.service;

import jakarta.persistence.NoResultException;
import kr.wonil.myspringboot.myexpense.data.dto.*;
import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;

import java.util.ArrayList;
import java.util.List;

public interface MyExpenseService {


    public List<MyMonthlyExpenseCodeDto> getMyMonthlyExpenseCodeTotal();
    public List<MyMonthlyExpenseCodeDto> getMyMonthlyExpenseCodeTotal(String month);
    public List<MyMonthlyExpenseTotalDto> getMyMonthlyExpenseTotal();

    public MyTransactionDto getMyTransactionById(int transactionId);

    public MyTransactionDto changeMyTransactionUseFlagById(int transactionId);

    public ArrayList<MyMonthlyExpenseTotalDto> getMyMonthlyExpenseTotal(String month);

    public MyMonthlyExpenseTotalSummaryDto getMyMonthlyExpenseTotalSummary(String month)  throws NoResultException;

    public ArrayList<MyTransactionViewDto> getMyMonthlyTransaction(String month);

    public ArrayList<MyMonthlyTotalByTransactionInfoDto> getMyMonthlyTotalByTransactionInfo(String month);

    public ArrayList<MyMonthlyTargetExpenseStatusDto> getMyMonthlyTargetExpenseStatus(String month);

    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodes();
    public ArrayList<ExpenseCodeDto> getExpenseCodes();
    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodesByTransactionInfo(String transactionInfo);
    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodesByTransactionId(String transactionId);


    public ArrayList<MyTransactionViewDto> getMyTransactionsByTransactionInfo(String transactionInfo);
    public ArrayList<MyTransactionViewDto> getMyTransactionsByTransactionId(String transactionId);

    public ArrayList<MyTransactionViewDto> getMyTransactionsByKeyword(String transactionInfo);

    public ArrayList<MyTransactionViewDto> getMyTransactionsByExpenseCode(String expenseCode, String date);

    public ArrayList<MyTransactionViewDto> getMyTransactionsByDate(String date);

    public ArrayList<MyTransactionViewDto> getMyTransactionsByCategoryCode(String expenseCode, String date);

    public ArrayList<MyTransactionDto> getMySpecialEventTransactions();

    public ArrayList<MyCurrentMonthExpenseTotalDto> getMyCurrentMonthExpenseTotal();

    public ArrayList<MyTransactionViewDto> getMyUncheckedTransaction();

    public ArrayList<MyExpenseStatisticDto> getMyExpenseStatistic();

    public ArrayList<MyMonthlyExpenseByExpenseCodeDto> getMyMonthlyExpenseByExpenseCode();

    public ArrayList<MyMonthlyExpenseByCategoryDto> getMyMonthlyExpenseByCategory();

    public ArrayList<MyMonthExpenseExpectDto> getMyMonthExpenseExpect();
    public ArrayList<MyMonthExpenseByTransactionNameDto> getMyMonthExpenseByTransactionName(String month);
    public ArrayList<MyDailyExpenseDto> getMyDailyExpense(String date, int limit);

    public MyTransaction saveMyTransaction(MyTransactionDto[] dtoArr);

    public MyTransaction updateMyTransaction(MyTransactionDto[] dtoArr);

    public ArrayList<MyWeeklyExpenseTotalDto> getMyWeeklyExpenseTotal(String year);
}
