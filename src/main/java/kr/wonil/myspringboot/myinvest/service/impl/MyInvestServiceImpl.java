package kr.wonil.myspringboot.myinvest.service.impl;

import kr.wonil.myspringboot.myinvest.data.dao.MyInvestDAO;
import kr.wonil.myspringboot.myinvest.data.dto.*;
import kr.wonil.myspringboot.myinvest.data.entity.*;
import kr.wonil.myspringboot.myinvest.service.MyInvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyInvestServiceImpl implements MyInvestService {

    private final MyInvestDAO myInvestDAO;


    @Override
    public List<BasePointDto> getTotalBasePoint() {

        List<BasePoint> entityList = myInvestDAO.selectTotalBasePoint();
        List<BasePointDto> dtoList = new ArrayList<>();
        BasePointDto dto = null;

        for(BasePoint entity : entityList){

            dto = new BasePointDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MyCoinPriceFlowDto> getMyCoinPriceFlow() {

        List<MyCoinPriceFlow> entityList = myInvestDAO.selectMyCoinPriceFlow();
        List<MyCoinPriceFlowDto> dtoList = new ArrayList<>();
        MyCoinPriceFlowDto dto = null;

        for(MyCoinPriceFlow entity : entityList){

            dto = new MyCoinPriceFlowDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MyMonthlyInvestTotalDto> getMyMonthlyInvestTotal(String month) {

        List<MyMonthlyInvestTotal> entityList = myInvestDAO.selectMyMonthlyInvestTotal(month);
        ArrayList<MyMonthlyInvestTotalDto> dtoList = new ArrayList<>();
        MyMonthlyInvestTotalDto dto = null;

        for(MyMonthlyInvestTotal entity : entityList){

            dto = new MyMonthlyInvestTotalDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyMonthlyInvestTotalDto> getMyMonthlyInvestTotal() {

        List<MyMonthlyInvestTotal> entityList = myInvestDAO.selectMyMonthlyInvestTotal();
        List<MyMonthlyInvestTotalDto> dtoList = new ArrayList<>();
        MyMonthlyInvestTotalDto dto = null;

        for(MyMonthlyInvestTotal entity : entityList){

            dto = new MyMonthlyInvestTotalDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyMonthlyInvestAmountViewDto> getMyMonthlyInvestAmount() {

        List<MyMonthlyInvestAmountView> entityList = myInvestDAO.selectMyMonthlyInvestAmount();
        List<MyMonthlyInvestAmountViewDto> dtoList = new ArrayList<>();
        MyMonthlyInvestAmountViewDto dto = null;

        for(MyMonthlyInvestAmountView entity : entityList){

            dto = new MyMonthlyInvestAmountViewDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyMonthlyInvestAmountViewDto> getMyMonthlyInvestAmount(String month) {

        List<MyMonthlyInvestAmountView> entityList = myInvestDAO.selectMyMonthlyInvestAmount(month);
        List<MyMonthlyInvestAmountViewDto> dtoList = new ArrayList<>();
        MyMonthlyInvestAmountViewDto dto = null;

        for(MyMonthlyInvestAmountView entity : entityList){

            dto = new MyMonthlyInvestAmountViewDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyYearlyInvestAmountViewDto> getMyYearlyInvestAmount() {

        List<MyYearlyInvestAmountView> entityList = myInvestDAO.selectMyYearlyInvestAmount();
        List<MyYearlyInvestAmountViewDto> dtoList = new ArrayList<>();
        MyYearlyInvestAmountViewDto dto = null;

        for(MyYearlyInvestAmountView entity : entityList){

            dto = new MyYearlyInvestAmountViewDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyYearlyInvestAmountViewDto> getMyYearlyInvestAmount(String year) {

        List<MyYearlyInvestAmountView> entityList = myInvestDAO.selectMyYearlyInvestAmount(year);
        List<MyYearlyInvestAmountViewDto> dtoList = new ArrayList<>();
        MyYearlyInvestAmountViewDto dto = null;

        for(MyYearlyInvestAmountView entity : entityList){

            dto = new MyYearlyInvestAmountViewDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<FxStatusDto> getFxStatus() {
        List<FxStatus> entityList = myInvestDAO.selectFxStatus();
        List<FxStatusDto> dtoList = new ArrayList<>();
        FxStatusDto dto = null;

        for(FxStatus entity : entityList){

            dto = new FxStatusDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<TotalFinanceStatusDto> getTotalFinanceStatus() {
        List<TotalFinanceStatus> entityList = myInvestDAO.selectTotalFinanceStatuses();
        List<TotalFinanceStatusDto> dtoList = new ArrayList<>();
        TotalFinanceStatusDto dto = null;

        for(TotalFinanceStatus entity : entityList){

            dto = new TotalFinanceStatusDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<YearlyMarginDto> getSnpYearlyMargin() {
        List<YearlyMargin> entityList = myInvestDAO.selectSnpYearlyMargin();
        List<YearlyMarginDto> dtoList = new ArrayList<>();
        YearlyMarginDto dto = null;

        for(YearlyMargin entity : entityList){

            dto = new YearlyMarginDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }


    @Override
    public List<SnPYoYDto> getSnpYoY() {
        List<SnPYoY> entityList = myInvestDAO.selectSnpYoY();
        List<SnPYoYDto> dtoList = new ArrayList<>();
        SnPYoYDto dto = null;

        for(SnPYoY entity : entityList){

            dto = new SnPYoYDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<SnpPriceToTopDto> getSnpPriceToTop() {
        List<SnpPriceToTop> entityList = myInvestDAO.selectSnpPriceToTop();
        List<SnpPriceToTopDto> dtoList = new ArrayList<>();
        SnpPriceToTopDto dto = null;

        for(SnpPriceToTop entity : entityList){

            dto = new SnpPriceToTopDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<MyInvestTotalStatusDto> getMyInvestTotalStatus() {
        List<MyInvestTotalStatus> entityList = myInvestDAO.selectMyInvestTotalStatus();
        List<MyInvestTotalStatusDto> dtoList = new ArrayList<>();
        MyInvestTotalStatusDto dto = null;

        for(MyInvestTotalStatus entity : entityList){

            dto = new MyInvestTotalStatusDto(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

}
