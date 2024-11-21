package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseTotal;
import kr.wonil.myspringboot.myexpense.data.entity.MyWeeklyExpenseTotal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MyWeeklyExpenseTotalRepository extends JpaRepository<MyWeeklyExpenseTotal, String> {

    List<MyWeeklyExpenseTotal> selectMyWeeklyExpenseTotalByYear(String year);
}
