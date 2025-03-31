package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MyStockHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyStockHistoryRepository extends JpaRepository<MyStockHistory, Integer> {

    @Query(value = "select m from MyStockHistory m " +
            "where m.stockNumber = :stockNumber " +
            "order by m.stockTradingDate desc ", nativeQuery = false)
    Page<MyStockHistory> findMyStockHistoriesByStockNumber(@Param("stockNumber") String stockNumber, Pageable pageable);

    @Query(value = "select m from MyStockHistory m order by m.stockTradingDate desc ", nativeQuery = false)
    Page<MyStockHistory> findMyStockHistories(Pageable pageable);



}
