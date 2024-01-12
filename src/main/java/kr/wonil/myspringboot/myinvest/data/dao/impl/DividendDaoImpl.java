package kr.wonil.myspringboot.myinvest.data.dao.impl;

import kr.wonil.myspringboot.myinvest.data.dao.DividendDAO;
import kr.wonil.myspringboot.myinvest.data.entity.DividendRate;
import kr.wonil.myspringboot.myinvest.repository.DividendComparisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DividendDaoImpl implements DividendDAO {

    private final DividendComparisonRepository dividendComparisonRepository;

    @Autowired
    public DividendDaoImpl(DividendComparisonRepository dividendComparisonRepository) {
        this.dividendComparisonRepository = dividendComparisonRepository;
    }

    @Override
    public DividendRate selectDividendRate(String stockNumber) {

        DividendRate dividendComparison = dividendComparisonRepository.getById(stockNumber);
        return dividendComparison;
    }

    @Override
    public List<DividendRate> selectDividendRate() {

        List<DividendRate> dividendComparisons = dividendComparisonRepository.findAll();
        return dividendComparisons;
    }
}
