package kr.wonil.myspringboot.myinvest.data.dao;

import kr.wonil.myspringboot.myinvest.data.entity.*;
import kr.wonil.myspringboot.myinvest.data.entity.FxStatus;

import java.util.List;

public interface MyInvestDAO {



    public List<MyInvestTotalStatus> selectMyInvestTotalStatus();
    public List<BasePoint> selectTotalBasePoint();

    public List<MyCoinPriceFlow> selectMyCoinPriceFlow();

    public List<MyMonthlyInvestTotal> selectMyMonthlyInvestTotal();

    public List<MyMonthlyInvestTotal> selectMyMonthlyInvestTotal(String month);

    public List<MyMonthlyInvestAmountView> selectMyMonthlyInvestAmount(String month);

    public List<MyMonthlyInvestAmountView> selectMyMonthlyInvestAmount();

    public List<MyYearlyInvestAmountView> selectMyYearlyInvestAmount(String year);

    public List<MyYearlyInvestAmountView> selectMyYearlyInvestAmount();
    public List<FxStatus> selectFxStatus();

    List<TotalFinanceStatus> selectTotalFinanceStatuses();

    public List<YearlyMargin> selectSnpYearlyMargin();

    public List<SnPYoY> selectSnpYoY();


}
