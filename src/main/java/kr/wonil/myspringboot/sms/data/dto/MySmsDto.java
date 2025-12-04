package kr.wonil.myspringboot.sms.data.dto;

import kr.wonil.myspringboot.sms.data.entity.MySms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySmsDto {

    Integer smsId;
    String smsBody;
    String sourceNumber;
    String smsDate;
    String smsLongDate;
    Long sourceSmsId;


    public MySmsDto(MySms mySms){
        smsId = mySms.getSmsId();
        smsBody = mySms.getSmsBody();
        sourceNumber = mySms.getSourceNumber();
        smsDate = mySms.getSmsDate();
        smsLongDate = mySms.getSmsLongDate() + "";
    }

}
