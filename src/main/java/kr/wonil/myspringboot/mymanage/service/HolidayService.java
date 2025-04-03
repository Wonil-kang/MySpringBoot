package kr.wonil.myspringboot.mymanage.service;

import kr.wonil.myspringboot.mymanage.data.dto.HolidayDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;

import java.util.List;

public interface HolidayService {

    public HolidayDto getHolidayByDate(String date);

    public boolean isHoliday(String date);
}
