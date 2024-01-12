package kr.wonil.myspringboot.sms.data.dao.impl;

import kr.wonil.test.myspringboot.sms.data.dao.MySmsDAO;
import kr.wonil.test.myspringboot.sms.data.entity.MySms;
import kr.wonil.test.myspringboot.sms.repository.MySmsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class MySmsDAOImpl implements MySmsDAO {

    private final MySmsRepository mySmsRepository;
    private Logger LOGGER = LoggerFactory.getLogger(MySmsDAOImpl.class);

    @Override
    public List<MySms> selectMySmsByDate(String date) {

        List<MySms> list = mySmsRepository.findMySmsByDate(date);
        return list;
    }

    @Override
    public List<MySms> selectMySmsBySourceNumberAndDate(String sourceNumber, String date) {
        List<MySms> list = mySmsRepository.findMySmsBySourceNumberAndSmsDate(sourceNumber, date);
        return list;
    }

    @Override
    public List<MySms> selectLatestMySms() {

        List<MySms> list = mySmsRepository.findLatestMySms();
        return list;
    }

    @Override
    public MySms insertSms(MySms mySms) {

        MySms result = null;

        try {

            result = mySmsRepository.save(mySms);

        }catch(Exception e){

            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }

}
