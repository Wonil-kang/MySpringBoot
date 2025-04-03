package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.StockInfo;
import kr.wonil.myspringboot.myinvest.data.entity.pk.StockInfoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StockInfoRepository extends JpaRepository<StockInfo, StockInfoPK> {

    @Modifying
    @Transactional
    @Query("""
        UPDATE StockInfo s
        SET s.stockName = :stockName,
            s.regDateTime = :regDateTime,
            s.modDateTime = :modDateTime,
            s.registrantId = :registrantId,
            s.modifierId = :modifierId,
            s.etfYn = :etfYn,
            s.stockPrice = :stockPrice,
            s.priceDifference = :priceDifference,
            s.priceDifferenceRatio = :priceDifferenceRatio,
            s.marketValue = :marketValue,
            s.tradingAmount = :tradingAmount,
            s.threeMonthEarnRate = :threeMonthEarnRate,
            s.nav = :nav,
            s.etfType = :etfType
        WHERE s.stockNumber = :stockNumber AND s.stockPriceDate = :stockPriceDate
    """)
    int updateStockInfo(
            @Param("stockNumber") String stockNumber,
            @Param("stockPriceDate") String stockPriceDate,
            @Param("stockName") String stockName,
            @Param("regDateTime") String regDateTime,
            @Param("modDateTime") String modDateTime,
            @Param("registrantId") String registrantId,
            @Param("modifierId") String modifierId,
            @Param("etfYn") String etfYn,
            @Param("stockPrice") Integer stockPrice,
            @Param("priceDifference") Integer priceDifference,
            @Param("priceDifferenceRatio") Double priceDifferenceRatio,
            @Param("marketValue") Integer marketValue,
            @Param("tradingAmount") Integer tradingAmount,
            @Param("threeMonthEarnRate") Double threeMonthEarnRate,
            @Param("nav") Double nav,
            @Param("etfType") String etfType
    );
}
