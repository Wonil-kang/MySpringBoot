package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "MY_TRANSACTION_WITH_EXPENSE_CODE_VIEW")
@Data
@Subselect("select * from MY_TRANSACTION_WITH_EXPENSE_CODE_VIEW")
public class MyTransactionView {

    @Id
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name = "SMS_BODY")
    private String smsBody;
    @Column(name = "SMS_ID")
    private String smsId;
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
    @Column(name = "MEMO")
    private String memo;
    @Column(name = "ACCUMULATED_EXPENSE")
    private String accumulatedExpense;
    @Column(name = "USE_YN")
    private String useFlag;
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
    @Column(name = "EXPENSE_CODE_NAME")
    private String expenseCodeName;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;


}
