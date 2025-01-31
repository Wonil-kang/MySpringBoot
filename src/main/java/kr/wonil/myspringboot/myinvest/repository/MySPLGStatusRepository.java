package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MySPLGStatus;
import kr.wonil.myspringboot.myinvest.data.entity.MyStockStatus;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MySPLGStatusRepository extends JpaRepository<MySPLGStatus, String> {


    @Query(value = "select * from MY_SPLG_STATUS_VIEW order by STOCK_PRICE_DATE desc limit 1"
            , nativeQuery = true)
    List<MySPLGStatus> findLastData();

}


