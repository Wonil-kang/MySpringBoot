package kr.wonil.myspringboot.sms.service.impl;

import kr.wonil.myspringboot.myexpense.controller.MyExpenseController;
import kr.wonil.myspringboot.myexpense.data.dao.MyExpenseDAO;
import kr.wonil.myspringboot.myexpense.data.dto.MyTransactionDto;
import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;
import kr.wonil.myspringboot.myexpense.service.MyExpenseService;
import kr.wonil.myspringboot.myinvest.controller.StockController;
import kr.wonil.myspringboot.myinvest.data.dto.MyStockHistoryDto;
import kr.wonil.myspringboot.sms.data.dao.MySmsDAO;
import kr.wonil.myspringboot.sms.data.dto.MySmsDto;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import kr.wonil.myspringboot.sms.parser.SmsParser;
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
    private final MyExpenseService myExpenseService;
    private final StockController stockController;


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

            mySms.setSourceSmsId(dto.getSmsId());
            mySms.setSmsBody(dto.getSmsBody());
            mySms.setSourceNumber(dto.getSourceNumber());
            mySms.setSmsDate(dto.getSmsDate());
            mySms.setRdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            mySms.setMdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            mySms.setRegisterId("SYS");
            mySms.setModifierId("SYS");
            mySms.setSmsLongDate(dto.getSmsLongDate());

            MySms result = mySmsDAO.insertSms(mySms);

            insertSmsDataToDB(result);

            if(mySmsDAO.selectMySmsBySourceNumberAndDate(mySms.getSourceNumber(), mySms.getSmsDate()).size() > 0)
                continue;

        }
        return null;

    }

    private void insertSmsDataToDB(MySms sms){

        MyTransactionDto mt = null;
        MyStockHistoryDto msh = null;
        MyTransaction mtRst = null;

        //KB Card
        if(sms.getSourceNumber().equals("15881688"))
            mt = SmsParser.parseKookminSms(sms);

        else if(sms.getSourceNumber().equals("15776200"))
            mt = SmsParser.parseHyundaiSms(sms);

        else if(sms.getSourceNumber().equals("15447200") || sms.getSourceNumber().equals("15447000"))
            mt = SmsParser.parseShinhanSms(sms);

        else if(sms.getSourceNumber().equals("15445000"))
            msh = SmsParser.parseHanKookStockSms(sms);

        if(sms.getSourceNumber().equals("01071128408"))
            msh = SmsParser.parseHanKookStockSms(sms);

        if(sms.getSourceNumber().equals("01071128408"))
            mt = SmsParser.parseShinhanSms(sms);

        if(mt != null) {
            mtRst = myExpenseService.saveMyTransaction(mt);
        }

        if(msh != null)
            stockController.uploadMyStockHistories(msh);

        if( mtRst != null && mtRst.getTransactionType().equals("취소")){

            myExpenseService.cancelMyTransaction(mtRst);
        }
    }
}
