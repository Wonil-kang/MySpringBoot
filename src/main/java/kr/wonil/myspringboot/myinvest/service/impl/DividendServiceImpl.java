package kr.wonil.myspringboot.myinvest.service.impl;

import kr.wonil.myspringboot.myinvest.data.dao.DividendDAO;
import kr.wonil.myspringboot.myinvest.data.dto.DividendRateDto;
import kr.wonil.myspringboot.myinvest.data.entity.DividendRate;
import kr.wonil.myspringboot.myinvest.service.DividendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DividendServiceImpl implements DividendService {

    private DividendDAO dividendDAO;

    @Autowired
    public DividendServiceImpl(DividendDAO dividendDAO) {
        this.dividendDAO = dividendDAO;
    }

    @Override
    public List<DividendRateDto> getDividendRate() {

        List<DividendRateDto> dtoList = new ArrayList<>();
        List<DividendRate> entityList
                = dividendDAO.selectDividendRate();
        DividendRateDto dto;

        for(DividendRate dc : entityList){

            dto = new DividendRateDto(dc);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
