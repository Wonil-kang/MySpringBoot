package kr.wonil.myspringboot.myexpense.data.dto;


import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;
import lombok.Data;

@Data
public class MyTransactionDto {

    private Integer transactionId;
    private String smsBody;
    private Integer smsId;
    private String cardName;
    private String ownerName;
    private String transactionType;
    private int transactionAmount;
    private String installmentPlan;
    private String dateTime;
    private String currency;
    private String transactionInfo;
    private String canceledTransactionId;
    private String memo;
    private String accumulatedExpense;
    private String useFlag;
    private String expenseCode;

    public MyTransactionDto(MyTransaction myTransaction){

        transactionId = myTransaction.getTransactionId();
        smsBody = myTransaction.getSmsBody();
        smsId = myTransaction.getSmsId();
        cardName = myTransaction.getCardName();
        ownerName = myTransaction.getOwnerName();
        transactionType = myTransaction.getTransactionType();
        transactionAmount = myTransaction.getTransactionAmount();
        installmentPlan = myTransaction.getInstallmentPlan();
        dateTime = myTransaction.getDateTime();
        currency = myTransaction.getCurrency();
        transactionInfo = myTransaction.getTransactionInfo();
        canceledTransactionId = myTransaction.getCanceledTransactionId();
        memo = myTransaction.getMemo();
        accumulatedExpense = myTransaction.getAccumulatedExpense();
        useFlag = myTransaction.getUseFlag();
        expenseCode = myTransaction.getExpenseCode();
        
    }

    public MyTransactionDto(){

    }
}
