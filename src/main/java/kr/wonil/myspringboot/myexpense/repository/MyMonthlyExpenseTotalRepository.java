package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseTotal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyMonthlyExpenseTotalRepository extends JpaRepository<MyMonthlyExpenseTotal, String> {
}
