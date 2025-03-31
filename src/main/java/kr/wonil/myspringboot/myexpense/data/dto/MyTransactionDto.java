package kr.wonil.myspringboot.myexpense.data.dto;


import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;
import kr.wonil.myspringboot.util.NumberUtil;
import lombok.Data;

import java.util.StringTokenizer;

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


    public void setCardName(String cardName) {

        if(cardName.endsWith("승인")) {

            this.cardName = cardName.replaceAll("체크승인","").replaceAll("승인", "").trim();
            this.transactionType = "승인";

            return;
        }

        else if(cardName.endsWith("취소")) {

            this.cardName = cardName.replaceAll("체크취소","").replaceAll("취소", "").trim();
            this.transactionType = "취소";

            return;
        }

        this.cardName = cardName;
    }

    public String getReadableTransactionAmount() {

        if(!currency.equals("KRW"))
            return NumberUtil.getReadableFloatNumber(transactionAmount,2);

        return NumberUtil.getReadableNumber(transactionAmount);
    }
    public void setTransactionAmount(String transactionAmount) {


        if(transactionAmount.contains("(")) {
            StringTokenizer st = new StringTokenizer(transactionAmount, "(");

            String amount = st.nextToken();
            String currency = st.nextToken(")");

            this.transactionAmount = NumberUtil.parseInt(amount.replaceAll(",", ""));
            this.currency = currency.replaceAll("\\(", "").replaceAll("\\)", "");
            return;
        }

        transactionAmount = transactionAmount.replaceAll("원", "")
                .replaceAll(",", "");

        this.transactionAmount = NumberUtil.parseInt(transactionAmount);
    }
    public void setDateTime(String dateTime, String date, String time) {

        date = date.replaceAll("/", "")
                .replaceAll(":", "");

        time = time.replaceAll("/", "")
                .replaceAll(":", "");

        this.dateTime = date + time;

        if(dateTime != null && dateTime.length() > 4)
            this.dateTime = dateTime.substring(0,4) + this.dateTime;

    }

    public void setDateTime(String dateTime, String date) {

        date = date.replaceAll("/", "")
                .replaceAll(":", "");


        this.dateTime = date + "0000";

        if(dateTime != null && dateTime.length() > 4)
            this.dateTime = dateTime.substring(0,4) + this.dateTime;

    }
    public void appendTransactionInfo(String transactionInfo) {
        this.transactionInfo = this.transactionInfo + " " + transactionInfo;
    }
    public void setAccumulatedExpense(String accumulatedExpense) {

        accumulatedExpense = accumulatedExpense.replaceAll("누적", "")
                .replaceAll("원", "")
                .replaceAll(",", "");

        this.accumulatedExpense = accumulatedExpense;
    }

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

        memo = "";
        useFlag = "Y";
        expenseCode = "-";
        accumulatedExpense = "0";
        installmentPlan = "-";
        transactionType = "-";
        ownerName = "-";
        currency = "KRW";
        canceledTransactionId = "-";

    }
}
