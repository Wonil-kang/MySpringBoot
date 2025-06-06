package kr.wonil.myspringboot.myinvest.service;

import kr.wonil.myspringboot.myinvest.data.dto.*;

import java.util.List;

public interface MyInvestService {

    public List<MyInvestTotalStatusDto> getMyInvestTotalStatus();
    public List<BasePointDto> getTotalBasePoint();

    public List<MyCoinPriceFlowDto> getMyCoinPriceFlow();

    public List<MyMonthlyInvestTotalDto> getMyMonthlyInvestTotal(String month);
    public List<MyMonthlyInvestTotalDto> getMyMonthlyInvestTotal();

    List<MyMonthlyInvestAmountViewDto> getMyMonthlyInvestAmount();

    List<MyMonthlyInvestAmountViewDto> getMyMonthlyInvestAmount(String month);

    List<MyYearlyInvestAmountViewDto> getMyYearlyInvestAmount();

    List<MyYearlyInvestAmountViewDto> getMyYearlyInvestAmount(String year);
    List<FxStatusDto> getFxStatus();

    List<TotalFinanceStatusDto> getTotalFinanceStatus();

    List<YearlyMarginDto> getSnpYearlyMargin();

    List<SnPYoYDto> getSnpYoY();

    List<SnpPriceToTopDto> getSnpPriceToTop();

    List<PriceToTopDto> getPriceToTop();

}
