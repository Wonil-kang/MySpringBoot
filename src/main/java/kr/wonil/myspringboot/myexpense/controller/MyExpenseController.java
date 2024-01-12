package kr.wonil.myspringboot.myexpense.controller;

import kr.wonil.myspringboot.myexpense.data.dto.*;
import kr.wonil.myspringboot.myexpense.service.MyExpenseService;
import kr.wonil.myspringboot.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-expense")
public class MyExpenseController {


    private final MyExpenseService myExpenseService;
    private Logger LOGGER = LoggerFactory.getLogger(MyExpenseController.class);

    @Autowired
    public MyExpenseController(MyExpenseService myExpenseService) {
        this.myExpenseService = myExpenseService;
    }


    @GetMapping("/my-monthly-expense-code-total")
    public ResponseEntity<List<MyMonthlyExpenseCodeDto>> getMyMonthlyExpenseCodeTotal(
            @RequestParam String month) {

        List<MyMonthlyExpenseCodeDto> dtoList = null;

        if(month == null || month.length() < 6)
            dtoList = myExpenseService.getMyMonthlyExpenseCodeTotal();
        else
            dtoList = myExpenseService.getMyMonthlyExpenseCodeTotal(month);

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping("/my-monthly-expense-total")
    public ResponseEntity<List<MyMonthlyExpenseTotalDto>> getMyMonthlyExpenseTotal(
            @RequestParam String month) {

        List<MyMonthlyExpenseTotalDto> dtoList = myExpenseService.getMyMonthlyExpenseTotal(month);

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping("/my-current-month-expense-total")
    public ResponseEntity<List<MyCurrentMonthExpenseTotalDto>> getCurrentMonthExpenseTotal() {

        List<MyCurrentMonthExpenseTotalDto> dtoList = myExpenseService.getMyCurrentMonthExpenseTotal();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @GetMapping("/my-monthly-expense-total-summary")
    public ResponseEntity<MyMonthlyExpenseTotalSummaryDto> getMyMonthlyExpenseTotalSummary(
            @RequestParam String month) {

        if(month == null || month.length() < 6)
            month = DateUtil.getCurrentKoreanDate().substring(0,6);

        MyMonthlyExpenseTotalSummaryDto dto = myExpenseService.getMyMonthlyExpenseTotalSummary(month);

        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }


    @GetMapping("/change-my-transaction-use-flag")
    public ResponseEntity<MyTransactionDto> changeMyTransactionUseFlagById(
            @RequestParam int transactionId) {

        MyTransactionDto dto = myExpenseService.changeMyTransactionUseFlagById(transactionId);

        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }



    @GetMapping("/my-monthly-transaction")
    public ResponseEntity<List<MyTransactionViewDto>> getMyMonthlyTransactions(
            @RequestParam String month) {

        if(month == null || month.length() < 6)
            month = DateUtil.getCurrentKoreanDate().substring(0,6);

        List<MyTransactionViewDto> list = myExpenseService.getMyMonthlyTransaction(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-unchecked-transaction")
    public ResponseEntity<List<MyTransactionViewDto>> getMyUncheckedTransactions() {

        List<MyTransactionViewDto> list = myExpenseService.getMyUncheckedTransaction();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-monthly-total-by-transaction-name")
    public ResponseEntity<List<MyMonthlyTotalByTransactionInfoDto>> getMyMonthlyTotalByTransactionInfo(
            @RequestParam String month) {

        if(month == null || month.length() < 6)
            month = DateUtil.getCurrentKoreanDate().substring(0,6);

        List<MyMonthlyTotalByTransactionInfoDto> list = myExpenseService.getMyMonthlyTotalByTransactionInfo(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-monthly-target-expense-status")
    public ResponseEntity<List<MyMonthlyTargetExpenseStatusDto>> getMyMonthlyTargetExpenseStatus(
            @RequestParam String month) {

        if(month == null || month.length() < 6)
            month = DateUtil.getCurrentKoreanDate().substring(0,6);

        List<MyMonthlyTargetExpenseStatusDto> list = myExpenseService.getMyMonthlyTargetExpenseStatus(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/expense-codes")
    public ResponseEntity<List<ExpenseCodeDto>> getExpenseCodes() {

        List<ExpenseCodeDto> list = myExpenseService.getExpenseCodes();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }
    @GetMapping("/recent-used-expense-codes")
    public ResponseEntity<List<ExpenseCodeDto>> getRecentUsedExpenseCodes() {

        List<ExpenseCodeDto> list = myExpenseService.getRecentUsedExpenseCodes();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/recent-used-expense-codes-by-transaction-info")
    public ResponseEntity<List<ExpenseCodeDto>> getRecentUsedExpenseCodesByTransactionInfo(
            @RequestParam String transactionInfo
    ) {

        List<ExpenseCodeDto> list = myExpenseService.getRecentUsedExpenseCodesByTransactionInfo(transactionInfo);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }



    @GetMapping("/my-transaction-by-transaction-id")
    public ResponseEntity<MyTransactionDto> getMyTransactionById(
            @RequestParam int transactionId
    ) {

        MyTransactionDto dto = myExpenseService.getMyTransactionById(transactionId);

        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }

    @GetMapping("/my-transactions-by-transaction-info")
    public ResponseEntity<List<MyTransactionViewDto>> getMyTransactionsByTransactionInfo(
            @RequestParam String transactionInfo) {

        List<MyTransactionViewDto> list = myExpenseService.getMyTransactionsByTransactionInfo(transactionInfo);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-transactions-by-expense-code")
    public ResponseEntity<List<MyTransactionViewDto>> getMyTransactionsByExpenseCode(
            @RequestParam String expenseCode, @RequestParam String date) {

        if(date == null)
            date = "-";

        List<MyTransactionViewDto> list = myExpenseService.getMyTransactionsByExpenseCode(expenseCode, date);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-transactions-by-date")
    public ResponseEntity<List<MyTransactionViewDto>> getMyTransactionsByDate(
            @RequestParam String date) {

        List<MyTransactionViewDto> list = myExpenseService.getMyTransactionsByDate(date);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-transactions-by-category-code")
    public ResponseEntity<List<MyTransactionViewDto>> getMyTransactionsByCategoryCode(
            @RequestParam String expenseCode, @RequestParam String date) {

        List<MyTransactionViewDto> list = myExpenseService.getMyTransactionsByCategoryCode(expenseCode, date);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-transactions-by-keyword")
    public ResponseEntity<List<MyTransactionViewDto>> getMyTransactionsByKeyword(
            @RequestParam String keyword) {

        List<MyTransactionViewDto> list = myExpenseService.getMyTransactionsByKeyword(keyword);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }




    @GetMapping("/my-special-event-transactions")
    public ResponseEntity<List<MyTransactionDto>> getMySpecialEventTransactions() {

        List<MyTransactionDto> list = myExpenseService.getMySpecialEventTransactions();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-month-expense-expect")
    public ResponseEntity<List<MyMonthExpenseExpectDto>> getMyMonthExpenseExpect() {

        List<MyMonthExpenseExpectDto> list = myExpenseService.getMyMonthExpenseExpect();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-month-expense-by-transaction-name")
    public ResponseEntity<List<MyMonthExpenseByTransactionNameDto>> getMyMonthExpenseByTransactionName(
            @RequestParam String month) {

        if(month == null || month.length() < 6)
            month = DateUtil.getCurrentKoreanDate().substring(0,6);

        List<MyMonthExpenseByTransactionNameDto> list = myExpenseService.getMyMonthExpenseByTransactionName(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-monthly-expense-by-expense-code")
    public ResponseEntity<List<MyMonthlyExpenseByExpenseCodeDto>> getMyMonthlyExpenseByExpenseCode() {

        List<MyMonthlyExpenseByExpenseCodeDto> list = myExpenseService.getMyMonthlyExpenseByExpenseCode();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-monthly-expense-by-category")
    public ResponseEntity<List<MyMonthlyExpenseByCategoryDto>> getMyMonthlyExpenseByCategory() {

        List<MyMonthlyExpenseByCategoryDto> list = myExpenseService.getMyMonthlyExpenseByCategory();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-daily-expense")
    public ResponseEntity<List<MyDailyExpenseDto>> getMyDailyExpense(
            @RequestParam String date, @RequestParam int limit) {

        List<MyDailyExpenseDto> list = null;

        if(date == null || date.length() < 4)
            list = myExpenseService.getMyDailyExpense(null, limit);
        else
            list = myExpenseService.getMyDailyExpense(date, -1);


        return ResponseEntity.status(HttpStatus.OK).body(list);

    }


    @PostMapping(value = "/insert-my-new-transaction" )
    public String uploadMyNewTransaction(@RequestBody MyTransactionDto[] dtoArr){

        LOGGER.info("uploadMyNewTransaction is called(" + dtoArr.length + ")");
        myExpenseService.saveMyTransaction(dtoArr);

        return "";

    }
}
