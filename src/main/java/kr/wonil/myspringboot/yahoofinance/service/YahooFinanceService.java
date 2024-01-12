package kr.wonil.myspringboot.yahoofinance.service;

import kr.wonil.test.myspringboot.yahoofinance.data.dto.FinancialIndicatorDto;
import kr.wonil.test.myspringboot.yahoofinance.data.dto.YahooDayInfoDataDto;

import java.util.List;

public interface YahooFinanceService {


    public List<FinancialIndicatorDto> getRecentFinancialIndicators();

    public List<YahooDayInfoDataDto> getYahooFinanceDayInfoData();
}
