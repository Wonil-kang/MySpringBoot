package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.dto.MyTransactionDto;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.Data;

@Entity
@Table(name = "my_transaction_tb")
@Data
public class MyTransaction {

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    @Column(name = "SMS_BODY", columnDefinition = "TEXT")
    private String smsBody;
    @Column(name = "SMS_ID")
    private Integer smsId;
    @Column(name = "CARD_NAME")
    private String cardName;
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;
    @Column(name = "TRANSACTION_AMOUNT")
    private int transactionAmount;
    @Column(name = "INSTALLMENT_PLAN")
    private String installmentPlan;
    @Column(name = "DATE_TIME")
    private String dateTime;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "TRANSACTION_INFO")
    private String transactionInfo;
    @Column(name = "CANCELED_TRANSACTION_ID")
    private String canceledTransactionId;
    @Column(name = "MEMO", columnDefinition = "TEXT")
    private String memo;
    @Column(name = "ACCUMULATED_EXPENSE")
    private String accumulatedExpense;
    @Column(name = "USE_YN")
    private String useFlag;
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;

    @Column(name = "RDTT")
    private String rdtt;
    @Column(name = "MDTT")
    private String mdtt;
    @Column(name = "REGR_ID")
    private String regrId;
    @Column(name = "MODR_ID")
    private String modrId;

    public MyTransaction(MyTransactionDto dto){

        transactionId = dto.getTransactionId();
        smsBody = dto.getSmsBody();
        smsId = dto.getSmsId();
        cardName = dto.getCardName();
        ownerName = dto.getOwnerName();
        transactionType = dto.getTransactionType();
        transactionAmount = dto.getTransactionAmount();
        installmentPlan = dto.getInstallmentPlan();
        dateTime = dto.getDateTime();
        currency = dto.getCurrency();
        transactionInfo = dto.getTransactionInfo();
        canceledTransactionId = dto.getCanceledTransactionId();
        memo = dto.getMemo();
        accumulatedExpense = dto.getAccumulatedExpense();
        useFlag = dto.getUseFlag();
        expenseCode = dto.getExpenseCode();
        rdtt = DateUtil.getCurrentKoreanDateTimeSecond();
        mdtt = DateUtil.getCurrentKoreanDateTimeSecond();
        regrId = "SYS";
        modrId = "SYS";
        
    }
    public MyTransaction() {

    }
}
