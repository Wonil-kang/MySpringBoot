package kr.wonil.myspringboot.myinvest.data.dao.impl;

import kr.wonil.test.myspringboot.myinvest.data.dao.MyInvestDAO;
import kr.wonil.test.myspringboot.myinvest.data.entity.*;
import kr.wonil.test.myspringboot.myinvest.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 @RequiredArgsConstructor
public class MyInvestDaoImpl implements MyInvestDAO {

    private final BasePointRepository basePointRepository;
    private final MyCoinPriceFlowRepository myCoinPriceFlowRepository;

    private final MyMonthlyInvestTotalRepository myMonthlyInvestTotalRepository;

    private final MyMonthlyInvestAmountRepository myMonthlyInvestAmountRepository;

    private final MyYearlyInvestAmountRepository myYearlyInvestAmountRepository;
    private final FxStatusRepository fxStatusRepository;
    private final MyInvestTotalStatusRepository myInvestTotalStatusRepository;
    private final YearlyMarginRepository yearlyMarginRepository;


    @Override
    public List<MyInvestTotalStatus> selectMyInvestTotalStatus() {
        List<MyInvestTotalStatus> list = myInvestTotalStatusRepository.findAll();
        return list;
    }

    @Override
    public List<BasePoint> selectTotalBasePoint() {

        List<BasePoint> list = basePointRepository.findAll();
        return list;
    }

    @Override
    public List<MyMonthlyInvestTotal> selectMyMonthlyInvestTotal(String month) {

        List<MyMonthlyInvestTotal> list = myMonthlyInvestTotalRepository.findMyMonthlyInvestTotalByMonth(month);
        return list;
    }

    @Override
    public List<MyMonthlyInvestAmountView> selectMyMonthlyInvestAmount(String month) {
        List<MyMonthlyInvestAmountView> list = myMonthlyInvestAmountRepository.findByMonth(month);
        return list;
    }

    @Override
    public List<MyMonthlyInvestAmountView> selectMyMonthlyInvestAmount() {
        return myMonthlyInvestAmountRepository.findAll();
    }

    @Override
    public List<MyYearlyInvestAmountView> selectMyYearlyInvestAmount(String year) {
        return myYearlyInvestAmountRepository.findByYear(year);
    }

    @Override
    public List<MyYearlyInvestAmountView> selectMyYearlyInvestAmount() {
        return myYearlyInvestAmountRepository.findAll();
    }

    @Override
    public List<FxStatus> selectFxStatus() {
        List<FxStatus> list = fxStatusRepository.findAll();
        return list;
    }

    @Override
    public List<YearlyMargin> selectSnpYearlyMargin() {

        List<YearlyMargin> list = yearlyMarginRepository.findAll();
        return list;
    }

    @Override
    public List<MyMonthlyInvestTotal> selectMyMonthlyInvestTotal() {

        List<MyMonthlyInvestTotal> list = myMonthlyInvestTotalRepository.findAll();
        return list;
    }

    @Override
    public List<MyCoinPriceFlow> selectMyCoinPriceFlow() {
        List<MyCoinPriceFlow> list = myCoinPriceFlowRepository.findAll();
        return list;
    }


}
