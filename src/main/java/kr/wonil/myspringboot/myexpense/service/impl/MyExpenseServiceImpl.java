package kr.wonil.myspringboot.myexpense.service.impl;

import kr.wonil.myspringboot.myexpense.data.dao.MyExpenseDAO;
import kr.wonil.myspringboot.myexpense.data.dto.*;
import kr.wonil.myspringboot.myexpense.data.entity.*;
import kr.wonil.myspringboot.myexpense.service.MyExpenseService;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyExpenseServiceImpl implements MyExpenseService {

    private final MyExpenseDAO myExpenseDAO;

    @Override
    public List<MyMonthlyExpenseCodeDto> getMyMonthlyExpenseCodeTotal() {

        List<MyMonthlyExpenseCodeDto> dtoList = new ArrayList<>();
        List<MyMonthlyExpenseCode> list
                = myExpenseDAO.selectMyMonthlyExpenseCode();

        MyMonthlyExpenseCodeDto dto;

        for(MyMonthlyExpenseCode ec : list){

            dto = new MyMonthlyExpenseCodeDto(ec);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<MyMonthlyExpenseCodeDto> getMyMonthlyExpenseCodeTotal(String month) {
        List<MyMonthlyExpenseCodeDto> dtoList = new ArrayList<>();
        List<MyMonthlyExpenseCode> list
                = myExpenseDAO.selectMyMonthlyExpenseCode(month);

        MyMonthlyExpenseCodeDto dto;

        for(MyMonthlyExpenseCode ec : list){

            dto = new MyMonthlyExpenseCodeDto(ec);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<MyMonthlyExpenseTotalDto> getMyMonthlyExpenseTotal() {

        List<MyMonthlyExpenseTotalDto> dtoList = new ArrayList<>();
        List<MyMonthlyExpenseTotal> list
                = myExpenseDAO.selectMyMonthlyExpenseTotal();

        MyMonthlyExpenseTotalDto dto;

        for(MyMonthlyExpenseTotal entity : list){

            dto = new MyMonthlyExpenseTotalDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public MyTransactionDto getMyTransactionById(int transactionId) {

        MyTransaction entity
                = myExpenseDAO.selectMyTransactionsById(transactionId);

        MyTransactionDto dto = new MyTransactionDto(entity);

        return dto;
    }

    @Override
    public MyTransactionDto changeMyTransactionUseFlagById(int transactionId) {


        MyTransaction entity
                = myExpenseDAO.selectMyTransactionsById(transactionId);

        if(entity.getUseFlag().equals("Y"))
            entity.setUseFlag("N");
        else
            entity.setUseFlag("Y");

        entity.setMdtt(DateUtil.getCurrentKoreanDateTimeSecond());
        entity.setModrId("WEB");

        MyTransaction newEntity = myExpenseDAO.updateMyTransaction(entity);
        MyTransactionDto dto = new MyTransactionDto(newEntity);

        return dto;
    }

    @Override
    public  ArrayList<MyMonthlyExpenseTotalDto> getMyMonthlyExpenseTotal(String month) {

        try {

            ArrayList<MyMonthlyExpenseTotalDto> dtoList = new ArrayList<>();

            MyMonthlyExpenseTotal entity = myExpenseDAO.selectMyMonthlyExpenseTotal(month);

            if(entity == null)
                dtoList.add(new MyMonthlyExpenseTotalDto(month, 0,0,0,0,0,0,0,0));
            else
                dtoList.add(new MyMonthlyExpenseTotalDto(entity));

            return dtoList;

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.toString());
        }

        return null;
    }

    @Override
    public ArrayList<MyMonthlyTotalByTransactionInfoDto> getMyMonthlyTotalByTransactionInfo(String month) {


        try {

            ArrayList<MyMonthlyTotalByTransactionInfoDto> dtoList = new ArrayList<>();

            List<MyMonthlyTotalByTransactionInfo> list
                    = myExpenseDAO.selectMyMonthlyTotalByTransactionInfo(month);

            MyMonthlyTotalByTransactionInfoDto dto;

            for (MyMonthlyTotalByTransactionInfo entity : list) {

                dto = new MyMonthlyTotalByTransactionInfoDto(entity);
                dtoList.add(dto);
            }

            return dtoList;

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.toString());
        }

        return null;
    }

    @Override
    public ArrayList<MyMonthlyTargetExpenseStatusDto> getMyMonthlyTargetExpenseStatus(String month) {


        try {

            ArrayList<MyMonthlyTargetExpenseStatusDto> dtoList = new ArrayList<>();

            List<MyMonthlyTargetExpenseStatus> list
                    = myExpenseDAO.selectMyMonthlyTargetExpenseStatus(month);

            MyMonthlyTargetExpenseStatusDto dto;

            for (MyMonthlyTargetExpenseStatus entity : list) {

                dto = new MyMonthlyTargetExpenseStatusDto(entity);
                dtoList.add(dto);
            }

            return dtoList;

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.toString());
        }

        return null;
    }


    @Override
    @NotFound(action = NotFoundAction.IGNORE)
    public MyMonthlyExpenseTotalSummaryDto getMyMonthlyExpenseTotalSummary(String month) {

        String previousMonth = DateUtil.shiftMonth(month + "01", -1).substring(0,6);
        MyMonthlyExpenseTotal current = null, previous = null;

        try {

            current = myExpenseDAO.selectMyMonthlyExpenseTotal(month);
            previous = myExpenseDAO.selectMyMonthlyExpenseTotal(previousMonth);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.toString());
        }

        if(current == null || current.getMonth() == null) {
            current = new MyMonthlyExpenseTotal();
            current.setMonth(month);
            current.setZero();
        }

        if(previous == null || previous.getMonth() == null){
            previous = new MyMonthlyExpenseTotal();
            previous.setMonth(previousMonth);
            previous.setZero();
        }


        MyMonthlyExpenseTotalSummaryDto dto = new MyMonthlyExpenseTotalSummaryDto(current, previous);

        return dto;
    }

    @Override
    public ArrayList<MyTransactionViewDto> getMyMonthlyTransaction(String month) {
        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyMonthlyTransaction(month);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }




    public ArrayList<MyMonthlyTotalByTransactionInfoDto> selectMyMonthlyTotalByTransactionInfo(String month) throws Exception{

        ArrayList<MyMonthlyTotalByTransactionInfoDto> dtoList = new ArrayList<>();
        List<MyMonthlyTotalByTransactionInfo> list
                = myExpenseDAO.selectMyMonthlyTotalByTransactionInfo(month);

        MyMonthlyTotalByTransactionInfoDto dto;

        for(MyMonthlyTotalByTransactionInfo entity : list){

            dto = new MyMonthlyTotalByTransactionInfoDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodes() {
        ArrayList<ExpenseCodeDto> dtoList = new ArrayList<>();
        List<ExpenseCode> list
                = myExpenseDAO.selectRecentUsedExpenseCodes();

        ExpenseCodeDto dto;

        for(ExpenseCode entity : list){

            dto = new ExpenseCodeDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<ExpenseCodeDto> getExpenseCodes() {
        ArrayList<ExpenseCodeDto> dtoList = new ArrayList<>();
        List<ExpenseCode> list
                = myExpenseDAO.selectExpenseCodes();

        ExpenseCodeDto dto;

        for(ExpenseCode entity : list){

            dto = new ExpenseCodeDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByTransactionInfo(String transactionInfo) {
        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByTransactionInfo(transactionInfo);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByTransactionId(String transactionId) {
        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByTransactionId(transactionId);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByKeyword(String keyword) {
        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByKeyword(keyword);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByExpenseCode(String expenseCode, String date) {

        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByExpenseCode(expenseCode, date);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByCategoryCode(String expenseCode, String date) {

        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByCategoryCode(expenseCode, date);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyTransactionViewDto> getMyTransactionsByDate(String date) {

        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyTransactionsByDate(date);

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyTransactionDto> getMySpecialEventTransactions() {
        ArrayList<MyTransactionDto> dtoList = new ArrayList<>();
        List<MyTransaction> list
                = myExpenseDAO.selectMyTransactionsByExpenseCode("101103");

        MyTransactionDto dto;

        for(MyTransaction entity : list){

            dto = new MyTransactionDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyCurrentMonthExpenseTotalDto> getMyCurrentMonthExpenseTotal() {
        ArrayList<MyCurrentMonthExpenseTotalDto> dtoList = new ArrayList<>();
        List<MyCurrentMonthExpenseTotal> list
                = myExpenseDAO.selectMyCurrentMonthExpenseTotal();

        MyCurrentMonthExpenseTotalDto dto;

        for(MyCurrentMonthExpenseTotal entity : list){

            dto = new MyCurrentMonthExpenseTotalDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodesByTransactionInfo(String transactionInfo) {
        ArrayList<ExpenseCodeDto> dtoList = new ArrayList<>();
        String newTransactionInfo = transactionInfo.replaceAll("%20", " ");
        List<ExpenseCode> list
                = myExpenseDAO.selectRecentUsedExpenseCodesByTransactionInfo(newTransactionInfo);

        ExpenseCodeDto dto;

        for(ExpenseCode entity : list){

            dto = new ExpenseCodeDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<ExpenseCodeDto> getRecentUsedExpenseCodesByTransactionId(String transactionId) {
        ArrayList<ExpenseCodeDto> dtoList = new ArrayList<>();

        List<ExpenseCode> list
                = myExpenseDAO.selectRecentUsedExpenseCodesByTransactionId(transactionId);

        ExpenseCodeDto dto;

        for(ExpenseCode entity : list){

            dto = new ExpenseCodeDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyTransactionViewDto> getMyUncheckedTransaction() {
        ArrayList<MyTransactionViewDto> dtoList = new ArrayList<>();
        List<MyTransactionView> list
                = myExpenseDAO.selectMyUncheckedTransaction();

        MyTransactionViewDto dto;

        for(MyTransactionView entity : list){

            dto = new MyTransactionViewDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyMonthlyExpenseByExpenseCodeDto> getMyMonthlyExpenseByExpenseCode() {

        ArrayList<MyMonthlyExpenseByExpenseCodeDto> dtoList = new ArrayList<>();
        List<MyMonthlyExpenseByExpenseCode> list
                = myExpenseDAO.selectMyMonthlyExpenseByExpenseCode();

        MyMonthlyExpenseByExpenseCodeDto dto;

        for(MyMonthlyExpenseByExpenseCode entity : list){

            dto = new MyMonthlyExpenseByExpenseCodeDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyMonthlyExpenseByCategoryDto> getMyMonthlyExpenseByCategory() {

        ArrayList<MyMonthlyExpenseByCategoryDto> dtoList = new ArrayList<>();
        List<MyMonthlyExpenseByCategory> list
                = myExpenseDAO.selectMyMonthlyExpenseByCategory();

        MyMonthlyExpenseByCategoryDto dto;

        for(MyMonthlyExpenseByCategory entity : list){

            dto = new MyMonthlyExpenseByCategoryDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public ArrayList<MyMonthExpenseExpectDto> getMyMonthExpenseExpect() {
        ArrayList<MyMonthExpenseExpectDto> dtoList = new ArrayList<>();

        List<MyMonthExpenseExpect> list
                = myExpenseDAO.selectMyMonthExpenseExpect();

        MyMonthExpenseExpectDto dto;

        for(MyMonthExpenseExpect entity : list){

            dto = new MyMonthExpenseExpectDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyMonthExpenseByTransactionNameDto> getMyMonthExpenseByTransactionName(String month) {
        ArrayList<MyMonthExpenseByTransactionNameDto> dtoList = new ArrayList<>();

        List<MyMonthExpenseByTransactionName> list
                = myExpenseDAO.selectMyMonthlyExpenseByTransactionName(month);

        MyMonthExpenseByTransactionNameDto dto;

        for(MyMonthExpenseByTransactionName entity : list){

            dto = new MyMonthExpenseByTransactionNameDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public ArrayList<MyDailyExpenseDto> getMyDailyExpense(String date, int limit) {

        ArrayList<MyDailyExpenseDto> dtoList = new ArrayList<>();
        List<MyDailyExpense> list = null;

        if(date == null)
            list = myExpenseDAO.selectMyDailyExpense(limit);
        else
            list = myExpenseDAO.selectMyDailyExpense(date);

        MyDailyExpenseDto dto;

        for(MyDailyExpense entity : list){

            dto = new MyDailyExpenseDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public MyTransaction saveMyTransaction(MyTransactionDto[] dtoArr) {

        for(int i=0; i< dtoArr.length; i++) {

            MyTransactionDto dto = dtoArr[i];

            MyTransaction entity = new MyTransaction(dto);

            MyTransaction result = myExpenseDAO.insertMyTransaction(entity);

        }

        return null;

    }

    public MyTransaction updateMyTransaction(MyTransactionDto[] dtoArr) {

        for(int i=0; i< dtoArr.length; i++) {

            MyTransactionDto dto = dtoArr[i];

            MyTransaction result = myExpenseDAO.updateMyTransaction(dto);

        }

        return null;

    }

}
