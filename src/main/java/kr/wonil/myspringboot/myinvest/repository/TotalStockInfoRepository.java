package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.StockInfo;
import kr.wonil.myspringboot.myinvest.data.entity.TotalStockInfo;
import kr.wonil.myspringboot.myinvest.data.entity.pk.StockInfoPK;
import kr.wonil.myspringboot.myinvest.data.entity.pk.TotalStockInfoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

public interface TotalStockInfoRepository extends JpaRepository<TotalStockInfo, TotalStockInfoPK> {

    @Modifying
    @Transactional
    @Query("""
        UPDATE TotalStockInfo s
        SET s.stockName = :stockName,
            s.stockPrice = :stockPrice
        WHERE s.stockCode = :stockCode AND s.date = :stockDate
    """)
    int updateTotalStockInfo(
            @Param("stockCode") String stockCode,
            @Param("stockPrice") BigInteger stockPrice,
            @Param("stockName") String stockName,
            @Param("stockDate") String stockDate
    );


    int countByStockCodeAndDate(String stockCode, String stockDate);
}
