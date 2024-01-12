package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyYearlyInvestAmountView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyYearlyInvestAmountRepository extends JpaRepository<MyYearlyInvestAmountView, String> {


    List<MyYearlyInvestAmountView> findByYear(String year);
}
