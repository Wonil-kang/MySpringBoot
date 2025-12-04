package kr.wonil.myspringboot.sms.data.dto;

import kr.wonil.myspringboot.sms.data.entity.MySms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySmsDto {

    Long smsId;
    String smsBody;
    String sourceNumber;
    String smsDate;
    long smsLongDate;
    Long sourceSmsId;


    public MySmsDto(MySms mySms){
        smsId = mySms.getSmsId();
        smsBody = mySms.getSmsBody();
        sourceNumber = mySms.getSourceNumber();
        smsDate = mySms.getSmsDate();
        smsLongDate = mySms.getSmsLongDate();
    }
}
