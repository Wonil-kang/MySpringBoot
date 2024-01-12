package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyMonthlyInvestTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyMonthlyInvestTotalRepository extends JpaRepository<MyMonthlyInvestTotal, String> {


    @Query(value = "select m from MyMonthlyInvestTotal m " +
            "where m.month = :month ", nativeQuery = false)
    List<MyMonthlyInvestTotal> findMyMonthlyInvestTotalByMonth(String month);


}
