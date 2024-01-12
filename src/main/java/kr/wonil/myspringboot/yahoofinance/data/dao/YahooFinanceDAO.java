package kr.wonil.myspringboot.yahoofinance.data.dao;

import kr.wonil.myspringboot.yahoofinance.data.entity.FinancialIndicator;
import kr.wonil.myspringboot.yahoofinance.data.entity.YahooDayInfoData;

import java.util.List;

public interface YahooFinanceDAO {

    public List<FinancialIndicator> selectRecentFinancialIndicators();

    public List<YahooDayInfoData> selectYahooDayInfoData();
}
