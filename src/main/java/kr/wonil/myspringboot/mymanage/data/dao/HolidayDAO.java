package kr.wonil.myspringboot.mymanage.data.dao;

import kr.wonil.myspringboot.mymanage.data.entity.Holiday;

import java.util.Optional;

public interface HolidayDAO {

    public Holiday selectHolidayByDate(String date);

}
