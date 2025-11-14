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
    @Column(name = "SRC_SMS_ID")
    Integer sourceSmsId;
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

    public int getSourceSmsId(){

        if(sourceSmsId == null) return -1;

        return sourceSmsId;
    }
}
