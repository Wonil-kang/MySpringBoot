package kr.wonil.myspringboot.mymanage.data.dao.impl;

import kr.wonil.myspringboot.mymanage.data.dao.HolidayDAO;
import kr.wonil.myspringboot.mymanage.data.entity.Holiday;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import kr.wonil.myspringboot.mymanage.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HolidayDAOImpl implements HolidayDAO {

    private final HolidayRepository holidayRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(HolidayDAOImpl.class);

    @Override
    public Holiday selectHolidayByDate(String date) {

        Optional<Holiday> rst = holidayRepository.findById(date);

        if(rst.isPresent()) {

            return rst.get();
        }

        return null;
    }
}
