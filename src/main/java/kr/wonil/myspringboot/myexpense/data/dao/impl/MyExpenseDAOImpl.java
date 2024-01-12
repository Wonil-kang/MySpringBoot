package kr.wonil.myspringboot.myexpense.data.dao.impl;

import kr.wonil.test.myspringboot.myexpense.data.dao.MyExpenseDAO;
import kr.wonil.test.myspringboot.myexpense.data.entity.*;
import kr.wonil.test.myspringboot.myexpense.repository.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MyExpenseDAOImpl implements MyExpenseDAO {

    private final MyMonthlyExpenseCodeRepository myMonthlyExpenseCodeRepository;
    private final MyMonthlyExpenseTotalRepository myMonthlyExpenseTotalRepository;
    private final MyTransactionViewRepository myTransactionViewRepository;
    private final MyTransactionRepository myTransactionRepository;
    private final ExpenseCodeRepository expenseCodeRepository;
    private final MyMonthlyTotalByTransactionInfoRepository myMonthlyTotalByTransactionInfoRepository;
    private final MyCurrentMonthExpenseTotalRepository myCurrentMonthExpenseTotalRepository;
    private final MyMonthExpenseExpectRepository myMonthExpenseExpectRepository;
    private final MyMonthlyExpenseByTransactionNameRepository myMonthlyExpenseByTransactionNameRepository;
    private final MyMonthlyTargetExpenseStatusRepository myMonthlyTargetExpenseStatusRepository;
    private final MyDailyExpenseRepository myDailyExpenseRepository;
    private final MyMonthlyExpenseByExpenseCodeRepository myMonthlyExpenseByExpenseCodeRepository;
    private final MyMonthlyExpenseByCategoryRepository myMonthlyExpenseByCategoryRepository;

    private Logger LOGGER = LoggerFactory.getLogger(MyExpenseDAOImpl.class);


    @Override
    public List<MyMonthlyExpenseCode> selectMyMonthlyExpenseCode() {

        List<MyMonthlyExpenseCode> list = myMonthlyExpenseCodeRepository.findAll();
        return list;
    }

    @Override
    public List<MyMonthlyExpenseCode> selectMyMonthlyExpenseCode(String month) {

        List<MyMonthlyExpenseCode> list = myMonthlyExpenseCodeRepository.findByMonthOrderBySumDesc(month);
        return list;
    }

    @Override
    public List<MyMonthlyExpenseTotal> selectMyMonthlyExpenseTotal() {

        List<MyMonthlyExpenseTotal> list = myMonthlyExpenseTotalRepository.findAll();

        return null;
    }

    @Override
    public MyMonthlyExpenseTotal selectMyMonthlyExpenseTotal(String month) throws Exception {

        Optional<MyMonthlyExpenseTotal> rst = myMonthlyExpenseTotalRepository.findById(month);

        if(rst.isPresent()) {

            return rst.get();
        }

        return null;
    }

    @Override
    public List<MyMonthlyTotalByTransactionInfo> selectMyMonthlyTotalByTransactionInfo(String month) throws Exception {

        List<MyMonthlyTotalByTransactionInfo> list = myMonthlyTotalByTransactionInfoRepository.findMyMonthlyTotalByTransactionInfosByAndMonth(month);
        return list;
    }

    @Override
    public List<MyTransactionView> selectMyMonthlyTransaction(String month) {

        List<MyTransactionView> list = myTransactionViewRepository.findByDateTimeStartsWithOrderByDateTimeDesc(month);

        return list;
    }

    @Override
    public List<MyMonthlyTargetExpenseStatus> selectMyMonthlyTargetExpenseStatus(String month) {
        List<MyMonthlyTargetExpenseStatus> list = myMonthlyTargetExpenseStatusRepository.getAllByMonth(month);
        return list;
    }

    @Override
    public List<ExpenseCode> selectExpenseCodes() {
        List<ExpenseCode> list = expenseCodeRepository.findAll();
        return list;
    }

    @Override
    public List<MyMonthlyExpenseByExpenseCode> selectMyMonthlyExpenseByExpenseCode() {
        List<MyMonthlyExpenseByExpenseCode> list = myMonthlyExpenseByExpenseCodeRepository.findAll();
        return list;
    }
    @Override
    public List<MyMonthlyExpenseByCategory> selectMyMonthlyExpenseByCategory() {
        List<MyMonthlyExpenseByCategory> list = myMonthlyExpenseByCategoryRepository.findAll();
        return list;
    }

    @Override
    public List<MyTransactionView> selectMyTransactionsByTransactionInfo(String transactionInfo) {

        List<MyTransactionView> list = myTransactionViewRepository.findAllByTransactionInfoLikeAndExpenseCodeNotOrderByDateTimeDesc(transactionInfo, "-");
        return list;
    }

    @Override
    public List<MyTransaction> selectMyTransactionsByExpenseCode(String expenseCode) {
        List<MyTransaction> list = myTransactionRepository.findAllByExpenseCodeOrderByDateTimeDesc(expenseCode);
        return list;
    }



    @Override
    public MyTransaction selectMyTransactionsById(int transactionId) {

        Optional<MyTransaction> selectedEntity = myTransactionRepository.findById(transactionId);

        if(selectedEntity.isPresent()){

            return selectedEntity.get();

        }

        return null;
    }

    @Override
    public MyTransaction updateMyTransaction(MyTransaction myTransaction) {

        return myTransactionRepository.save(myTransaction);
    }

    @Override
    public List<MyCurrentMonthExpenseTotal> selectMyCurrentMonthExpenseTotal() {
        List<MyCurrentMonthExpenseTotal> list = myCurrentMonthExpenseTotalRepository.findAll();
        return list;
    }

    @Override
    public List<MyTransactionView> selectMyUncheckedTransaction() {
        List<MyTransactionView> list = myTransactionViewRepository.findAllMyUncheckedTransaction();
        return list;
    }

    @Override
    public List<MyMonthExpenseExpect> selectMyMonthExpenseExpect() {
        List<MyMonthExpenseExpect> list = myMonthExpenseExpectRepository.findAll();
        return list;
    }

    @Override
    public List<MyMonthExpenseByTransactionName> selectMyMonthlyExpenseByTransactionName(String month) {
        List<MyMonthExpenseByTransactionName> list = myMonthlyExpenseByTransactionNameRepository.findByMonth(month);
        return list;
    }

    @Override
    public List<MyDailyExpense> selectMyDailyExpense(int limit) {

        Page<MyDailyExpense> page = myDailyExpenseRepository.findTopN(PageRequest.of(0,limit));

        return page.getContent();
    }

    @Override
    public List<MyDailyExpense> selectMyDailyExpense(String date) {
        List<MyDailyExpense> list = myDailyExpenseRepository.findAllByDateStartsWith(date);
        return list;
    }

    @Override
    public List<ExpenseCode> selectRecentUsedExpenseCodes() {

        List<ExpenseCode> list = expenseCodeRepository.findAllByOrderByRecentUsedDateDesc();
        return list;
    }

    public List<ExpenseCode> selectRecentUsedExpenseCodesByTransactionInfo(String transactionInfo) {

        List<ExpenseCode> list = expenseCodeRepository.selectExpenseCodesByTransactionInfo(transactionInfo);

        return list;
    }

    @Override
    public List<MyTransactionView> selectMyTransactionsByExpenseCode(String expenseCode, String date) {

        List<MyTransactionView> list = null;

        if(date.length() < 4)
            list = myTransactionViewRepository.findAllByExpenseCode(expenseCode);

        else
            list = myTransactionViewRepository.findAllByExpenseCodeAndDateTime(expenseCode, date);

        return list;
    }

    @Override
    public List<MyTransactionView> selectMyTransactionsByCategoryCode(String expenseCode, String date) {
        List<MyTransactionView> list = myTransactionViewRepository.findAllByCategoryCodeAndDateTime(expenseCode, date);
        return list;
    }

    @Override
    public List<MyTransactionView> selectMyTransactionsByDate(String date) {
        List<MyTransactionView> list = myTransactionViewRepository.findAllByDateTime(date);
        return list;
    }

    @Override
    public List<MyTransactionView> selectMyTransactionsByKeyword(String keyword) {
        List<MyTransactionView> list = myTransactionViewRepository.findAllByTransactionInfoContainingOrMemoContainingOrderByDateTimeDesc(keyword, keyword);
        return list;
    }




    @Override
    public MyTransaction insertMyTransaction(MyTransaction myTransaction) {

        MyTransaction result = null;

        try {

            result = myTransactionRepository.save(myTransaction);

        }catch(Exception e){

            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }


}
