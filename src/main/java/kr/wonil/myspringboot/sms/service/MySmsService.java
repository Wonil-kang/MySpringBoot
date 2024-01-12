package kr.wonil.myspringboot.sms.service;

import kr.wonil.myspringboot.sms.data.dto.MySmsDto;
import kr.wonil.myspringboot.sms.data.entity.MySms;

import java.util.List;

public interface MySmsService {

    public List<MySmsDto> getMySmsBySmsDate(String date);

    public List<MySmsDto> getLatestMySmsBySmsDate();
    MySms saveMySms(MySmsDto[] mySmsDto);
}
