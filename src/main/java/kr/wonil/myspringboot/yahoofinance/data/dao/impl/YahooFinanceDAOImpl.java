package kr.wonil.myspringboot.yahoofinance.data.dao.impl;

import kr.wonil.test.myspringboot.yahoofinance.data.dao.YahooFinanceDAO;
import kr.wonil.test.myspringboot.yahoofinance.data.entity.FinancialIndicator;
import kr.wonil.test.myspringboot.yahoofinance.data.entity.YahooDayInfoData;
import kr.wonil.test.myspringboot.yahoofinance.repository.FinancialIndicatorRepository;
import kr.wonil.test.myspringboot.yahoofinance.repository.YahooFinanceDayInfoDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class YahooFinanceDAOImpl implements YahooFinanceDAO {
    private final FinancialIndicatorRepository financialIndicatorRepository;
    private final YahooFinanceDayInfoDataRepository yahooFinanceDayInfoDataRepository;


    @Override
    public List<FinancialIndicator> selectRecentFinancialIndicators() {
        List<FinancialIndicator> list = financialIndicatorRepository.selectRecentFinancialIndicator();

        return list;
    }

    @Override
    public List<YahooDayInfoData> selectYahooDayInfoData() {

        List<YahooDayInfoData> list = yahooFinanceDayInfoDataRepository.findAll();
        return list;
    }
}
