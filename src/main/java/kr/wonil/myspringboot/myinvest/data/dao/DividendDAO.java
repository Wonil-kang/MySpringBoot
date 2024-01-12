package kr.wonil.myspringboot.myinvest.data.dao;

import kr.wonil.test.myspringboot.myinvest.data.entity.DividendRate;

import java.util.List;

public interface DividendDAO {

    public DividendRate selectDividendRate(String stockNumber);

    public List<DividendRate> selectDividendRate();
}
