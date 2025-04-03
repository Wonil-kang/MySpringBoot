package kr.wonil.myspringboot.mymanage.service.impl;

import kr.wonil.myspringboot.mymanage.data.dao.HolidayDAO;
import kr.wonil.myspringboot.mymanage.data.dao.MyMemoDAO;
import kr.wonil.myspringboot.mymanage.data.dto.HolidayDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import kr.wonil.myspringboot.mymanage.service.HolidayService;
import kr.wonil.myspringboot.mymanage.service.MyMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {


    private final HolidayDAO holidayDAO;


    @Override
    public HolidayDto getHolidayByDate(String date) {

        return new HolidayDto(holidayDAO.selectHolidayByDate(date));
    }

    @Override
    public boolean isHoliday(String date) {

        HolidayDto dto = getHolidayByDate(date);

        if(dto.getDate() != null) return true;

        return false;
    }

}
