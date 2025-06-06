package kr.wonil.myspringboot.myexpense.data.dao;

import kr.wonil.myspringboot.myexpense.data.dto.MyTransactionDto;
import kr.wonil.myspringboot.myexpense.data.entity.*;

import java.util.List;

public interface MyExpenseDAO {

    public List<MyMonthlyExpenseCode> selectMyMonthlyExpenseCode();
    public List<MyMonthlyExpenseCode> selectMyMonthlyExpenseCode(String month);

    public List<MyMonthlyExpenseTotal> selectMyMonthlyExpenseTotal();
    public MyMonthlyExpenseTotal selectMyMonthlyExpenseTotal(String month) throws Exception;


    public List<MyMonthlyTotalByTransactionInfo> selectMyMonthlyTotalByTransactionInfo(String month) throws Exception;

    public List<MyTransactionView> selectMyMonthlyTransaction(String month);
    public List<MyMonthlyTargetExpenseStatus> selectMyMonthlyTargetExpenseStatus(String month);
    public List<ExpenseCode> selectExpenseCodes();
    public List<ExpenseCode> selectRecentUsedExpenseCodes();
    public List<ExpenseCode> selectRecentUsedExpenseCodesByTransactionInfo(String transactionInfo);
    public List<ExpenseCode> selectRecentUsedExpenseCodesByTransactionId(String transactionId);

    public List<MyTransactionView> selectMyTransactionsByTransactionInfo(String transactionInfo);
    public List<MyTransactionView> selectMyTransactionsByTransactionId(String transactionId);

    public List<MyTransaction> selectMyTransactionsByExpenseCode(String expenseCode);

    public List<MyTransactionView> selectMyTransactionsByExpenseCode(String expenseCode, String date);

    public List<MyTransactionView> selectMyTransactionsByCategoryCode(String expenseCode, String date);
    public List<MyTransactionView> selectMyTransactionsByDate(String date);

    public MyTransaction selectMyTransactionsById(int transactionId);

    public List<MyTransactionView> selectMyTransactionsByKeyword(String transactionInfo);

    public MyTransaction updateMyTransaction(MyTransaction myTransaction);

    public List<MyCurrentMonthExpenseTotal> selectMyCurrentMonthExpenseTotal();

    public List<MyTransactionView> selectMyUncheckedTransaction();

    public List<MyMonthExpenseExpect> selectMyMonthExpenseExpect();


    public List<MyMonthExpenseByTransactionName> selectMyMonthlyExpenseByTransactionName(String month);

    public List<MyDailyExpense> selectMyDailyExpense(String date);

    public List<MyDailyExpense> selectMyDailyExpense(int limit);

    public MyTransaction insertMyTransaction(MyTransaction myTransaction);

    public MyTransaction updateMyTransaction(MyTransactionDto myTransactionDto);

    public List<MyMonthlyExpenseByExpenseCode> selectMyMonthlyExpenseByExpenseCode();

    public List<MyMonthlyExpenseByCategory> selectMyMonthlyExpenseByCategory();

    public List<MyExpenseStatistic> selectMyExpenseStatistic();

    public List<MyWeeklyExpenseTotal> selectMyWeeklyExpenseTotal(String year);

    public int cancelMyTransaction(MyTransaction myTransaction);

    public int updateExpenseCodeRecentUsedDate(String expenseCode);

    public ExpenseCode selectExpenseCodeByExpenseCode(String expenseCode);


}
