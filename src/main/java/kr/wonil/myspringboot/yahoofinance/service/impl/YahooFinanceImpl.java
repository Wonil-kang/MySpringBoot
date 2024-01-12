package kr.wonil.myspringboot.yahoofinance.service.impl;

import kr.wonil.myspringboot.yahoofinance.data.dao.YahooFinanceDAO;
import kr.wonil.myspringboot.yahoofinance.data.dto.FinancialIndicatorDto;
import kr.wonil.myspringboot.yahoofinance.data.dto.YahooDayInfoDataDto;
import kr.wonil.myspringboot.yahoofinance.data.entity.FinancialIndicator;
import kr.wonil.myspringboot.yahoofinance.data.entity.YahooDayInfoData;
import kr.wonil.myspringboot.yahoofinance.service.YahooFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YahooFinanceImpl implements YahooFinanceService {

    private final YahooFinanceDAO yahooFinanceDAO;

    @Override
    public List<FinancialIndicatorDto> getRecentFinancialIndicators() {
        ArrayList<FinancialIndicatorDto> dtoList = new ArrayList<>();
        List<FinancialIndicator> list
                = yahooFinanceDAO.selectRecentFinancialIndicators();

        FinancialIndicatorDto dto;

        for(FinancialIndicator entity : list){

            dto = new FinancialIndicatorDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<YahooDayInfoDataDto> getYahooFinanceDayInfoData() {
        ArrayList<YahooDayInfoDataDto> dtoList = new ArrayList<>();
        List<YahooDayInfoData> list
                = yahooFinanceDAO.selectYahooDayInfoData();

        YahooDayInfoDataDto dto;

        for(YahooDayInfoData entity : list){

            dto = new YahooDayInfoDataDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
