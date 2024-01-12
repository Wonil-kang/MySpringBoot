package kr.wonil.myspringboot.sms.data.dao;

import kr.wonil.myspringboot.sms.data.entity.MySms;

import java.util.List;

public interface MySmsDAO {

    public List<MySms> selectMySmsByDate(String date);

    public List<MySms> selectMySmsBySourceNumberAndDate(String sourceNumber, String date);

    public List<MySms> selectLatestMySms();

    public MySms insertSms(MySms mySms);


}
