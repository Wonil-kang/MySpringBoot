package kr.wonil.myspringboot.yahoofinance.repository;

import kr.wonil.test.myspringboot.yahoofinance.data.entity.YahooDayInfoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YahooFinanceDayInfoDataRepository extends JpaRepository<YahooDayInfoData, String> {


}
