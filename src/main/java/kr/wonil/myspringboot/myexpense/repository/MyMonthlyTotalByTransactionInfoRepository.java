package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyTotalByTransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyMonthlyTotalByTransactionInfoRepository extends JpaRepository<MyMonthlyTotalByTransactionInfo, String> {


    @Query(value = "select m from MyMonthlyTotalByTransactionInfo m " +
            "where m.month = :month ", nativeQuery = false)
    List<MyMonthlyTotalByTransactionInfo> findMyMonthlyTotalByTransactionInfosByAndMonth(String month);
}
