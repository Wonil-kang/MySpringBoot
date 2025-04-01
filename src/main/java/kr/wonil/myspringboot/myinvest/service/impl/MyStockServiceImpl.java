package kr.wonil.myspringboot.myinvest.service.impl;

import jakarta.persistence.EntityManager;
import kr.wonil.myspringboot.myinvest.data.dao.MyStockDAO;
import kr.wonil.myspringboot.myinvest.data.dto.*;
import kr.wonil.myspringboot.myinvest.data.entity.*;
import kr.wonil.myspringboot.myinvest.service.MyStockService;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyStockServiceImpl implements MyStockService {

    private final MyStockDAO myStockDAO;
    private final EntityManager entityManager;

    private final Logger LOGGER = LoggerFactory.getLogger(MyStockServiceImpl.class);


    @Override
    public List<MyStockStatusDto> getAllMyStockStatus() {

        List<MyStockStatusDto> dtoList = new ArrayList<>();
        List<MyStockStatus> entityList
                = myStockDAO.selectMyStockStatus();

        MyStockStatusDto dto;

        for(MyStockStatus entity : entityList){

            dto = new MyStockStatusDto(entity);
            dtoList.add(dto);

        }


        return dtoList;
    }

    @Override
    public List<MyStockPriceFlowDto> getMyStockPriceFlow() {

        List<MyStockPriceFlowDto> dtoList = new ArrayList<>();
        List<MyStockPriceFlow> entityList
                = myStockDAO.selectMyStockPriceFlow();

        MyStockPriceFlowDto dto;

        for(MyStockPriceFlow entity : entityList){

            dto = new MyStockPriceFlowDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MyStockHistoryDto> getMyStockHistories(int limit) {

        List<MyStockHistoryDto> dtoList = new ArrayList<>();
        List<MyStockHistory> entityList
                = myStockDAO.selectMyStockHistory(limit);

        MyStockHistoryDto dto;

        for(MyStockHistory entity : entityList){

            dto = new MyStockHistoryDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MyStockHistoryDto> getMyStockHistoriesByStockNumber(String stockNumber, int limit) {

        List<MyStockHistoryDto> dtoList = new ArrayList<>();
        List<MyStockHistory> entityList
                = myStockDAO.selectMyStockHistoryByStockNumber(stockNumber, limit);

        MyStockHistoryDto dto;

        for(MyStockHistory entity : entityList){

            dto = new MyStockHistoryDto(entity);
            if(dto.getNumberOfStock() < 1) continue;
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<LastStockPriceDto> getLastStockPrice() {

        List<LastStockPrice> entityList = myStockDAO.selectLastStockPrice();
        List<LastStockPriceDto> dtoList = new ArrayList<>();
        LastStockPriceDto dto = null;

        for(LastStockPrice entity : entityList){

            dto = new LastStockPriceDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MySPLGStatusDto> getMyLastSPLGStatus() {

        List<MySPLGStatus> entityList = myStockDAO.selectMyLastSPLGStatus();
        List<MySPLGStatusDto> dtoList = new ArrayList<>();
        MySPLGStatusDto dto = null;

        for(MySPLGStatus entity : entityList){

            dto = new MySPLGStatusDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Transactional
    @Override
    public List<MyStockHistoryDto> saveMyStockHistories(MyStockHistoryDto[] dtoArr) {

        for(int i=0; i< dtoArr.length; i++) {

            MyStockHistoryDto dto = dtoArr[i];

            MyStockHistory entity = new MyStockHistory(dto);

            entity.setRdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            entity.setMdtt(DateUtil.getCurrentKoreanDateTimeSecond());
            entity.setModifierId("SYS");
            entity.setRegisterId("SYS");

            MyStockHistory result = myStockDAO.insertMyStockHistory(entity);

        }

        // * -------------------- STOCK INFO UPDATE PROCEDURE -------------------- * //

        // Flush to ensure inserts are actually sent to DB
        entityManager.flush();

        try {

            entityManager.createStoredProcedureQuery("PRC_UPDATE_MY_STOCK_STATUS").execute();
            entityManager.createStoredProcedureQuery("PRC_UPDATE_MY_STOCK_PRICE_FLOW").execute();

        }catch (Exception ex) {
            LOGGER.error("Failed to execute my stock procedure", ex);
            throw ex; // 트랜잭션 유지하려면 다시 던져야 함
        }

        // * -------------------- STOCK INFO UPDATE PROCEDURE -------------------- * //

        return null;

    }
}
