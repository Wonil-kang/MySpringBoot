package kr.wonil.myspringboot.sms.service.impl;

import kr.wonil.myspringboot.sms.data.dao.MySmsDAO;
import kr.wonil.myspringboot.sms.data.dto.MySmsDto;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import kr.wonil.myspringboot.sms.service.MySmsService;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MySmsServiceImpl implements MySmsService {

    private final MySmsDAO mySmsDAO;


    @Override
    public List<MySmsDto> getMySmsBySmsDate(String date) {

        List<MySmsDto> dtoList = new ArrayList<>();
        List<MySms> entityList
                = mySmsDAO.selectMySmsByDate(date);

        MySmsDto dto;

        for(MySms entity : entityList){

            dto = new MySmsDto(entity);
            dtoList.add(dto);

        }


        return dtoList;
    }

    @Override
    public List<MySmsDto> getLatestMySmsBySmsDate() {
        List<MySmsDto> dtoList = new ArrayList<>();
        List<MySms> entityList
                = mySmsDAO.selectLatestMySms();

        MySmsDto dto;

        for(MySms entity : entityList){

            dto = new MySmsDto(entity);
            dtoList.add(dto);

        }


        return dtoList;
    }

    @Override
    public MySms saveMySms(MySmsDto[] mySmsDtoArr) {

        for(int i=0; i< mySmsDtoArr.length; i++) {

            MySmsDto dto = mySmsDtoArr[i];

            MySms mySms = new MySms();

            mySms.setSmsBody(dto.getSmsBody());
            mySms.setSourceNumber(dto.getSourceNumber());
            mySms.setSmsDate(dto.getSmsDate());
            mySms.setRdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            mySms.setMdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            mySms.setRegisterId("SYS");
            mySms.setModifierId("SYS");
            mySms.setReflectTransactionFlag("N");
            mySms.setTransactionErrorFlag("N");
            mySms.setReflectStockFlag("N");
            mySms.setStockErrorFlag("N");
            mySms.setSmsLongDate(dto.getSmsLongDate());

            if(mySmsDAO.selectMySmsBySourceNumberAndDate(mySms.getSourceNumber(), mySms.getSmsDate()).size() > 0)
                continue;

            MySms result = mySmsDAO.insertSms(mySms);

        }
        return null;

    }
}
