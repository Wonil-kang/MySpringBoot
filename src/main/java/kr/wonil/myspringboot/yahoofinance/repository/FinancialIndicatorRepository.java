package kr.wonil.myspringboot.yahoofinance.repository;

import kr.wonil.test.myspringboot.yahoofinance.data.entity.FinancialIndicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinancialIndicatorRepository extends JpaRepository<FinancialIndicator, Integer> {



    @Query(value = "select * from YAHOO_FINANCE_DATA_TB t where (t.ticker, t.date) in " +
            "(select f.ticker, max(f.date) from YAHOO_FINANCE_DATA_TB f group by f.ticker)"
    , nativeQuery = true)
    List<FinancialIndicator> selectRecentFinancialIndicator();

}
