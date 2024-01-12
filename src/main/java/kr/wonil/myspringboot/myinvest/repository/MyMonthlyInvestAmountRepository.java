package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MyMonthlyInvestAmountView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyMonthlyInvestAmountRepository extends JpaRepository<MyMonthlyInvestAmountView, String> {


    List<MyMonthlyInvestAmountView> findByMonth(String month);
}
