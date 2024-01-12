package kr.wonil.myspringboot.myexpense.data.dto;


import kr.wonil.myspringboot.myexpense.data.entity.MyTransactionView;
import lombok.Data;

@Data
public class MyTransactionViewDto {

    private String transactionId;
    private String smsBody;
    private String smsId;
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
    private String expenseCodeName;
    private String categoryName;
    
    public MyTransactionViewDto(MyTransactionView myTransactionView){

        transactionId = myTransactionView.getTransactionId();
        smsBody = myTransactionView.getSmsBody();
        smsId = myTransactionView.getSmsId();
        cardName = myTransactionView.getCardName();
        ownerName = myTransactionView.getOwnerName();
        transactionType = myTransactionView.getTransactionType();
        transactionAmount = myTransactionView.getTransactionAmount();
        installmentPlan = myTransactionView.getInstallmentPlan();
        dateTime = myTransactionView.getDateTime();
        currency = myTransactionView.getCurrency();
        transactionInfo = myTransactionView.getTransactionInfo();
        canceledTransactionId = myTransactionView.getCanceledTransactionId();
        memo = myTransactionView.getMemo();
        accumulatedExpense = myTransactionView.getAccumulatedExpense();
        useFlag = myTransactionView.getUseFlag();
        expenseCode = myTransactionView.getExpenseCode();
        expenseCodeName = myTransactionView.getExpenseCodeName();
        categoryName = myTransactionView.getCategoryName();
        
    }
}
