package kr.wonil.myspringboot.myinvest.service;

import kr.wonil.test.myspringboot.myinvest.data.dto.DividendRateDto;

import java.util.List;

public interface DividendService {

    public List<DividendRateDto> getDividendRate();

}
