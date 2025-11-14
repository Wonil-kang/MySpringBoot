package kr.wonil.myspringboot.sms.data.dto;

import kr.wonil.myspringboot.sms.data.entity.MySms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySmsDto {

    int smsId;
    String smsBody;
    String sourceNumber;
    String smsDate;
    long smsLongDate;


    public MySmsDto(MySms mySms){
        smsId = mySms.getSourceSmsId();
        smsBody = mySms.getSmsBody();
        sourceNumber = mySms.getSourceNumber();
        smsDate = mySms.getSmsDate();
        smsLongDate = mySms.getSmsLongDate();
    }
}
