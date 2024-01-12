package kr.wonil.myspringboot.sms.data.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "sms_tb")
@Data
public class MySms {

    @Id
    @Column(name = "SMS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int smsId;
    @Column(name = "SMS_BODY", columnDefinition = "TEXT")
    String smsBody;
    @Column(name = "SRC_NUMBER")
    String sourceNumber;
    @Column(name = "SMS_DATE")
    String smsDate;
    @Column(name = "SMS_DATE_LONG")
    long smsLongDate;
    @Column(name = "RDTT")
    String rdtt;
    @Column(name = "MDTT")
    String mdtt;
    @Column(name = "REGR_ID")
    String registerId;
    @Column(name = "MODR_ID")
    String modifierId;
    @Column(name = "RFLT_TRANSACTION_YN")
    String reflectTransactionFlag;
    @Column(name = "TRANSACTION_ERR_YN")
    String transactionErrorFlag;
    @Column(name = "RFLT_STOCK_YN")
    String reflectStockFlag;
    @Column(name = "STOCK_ERR_YN")
    String stockErrorFlag;
}
