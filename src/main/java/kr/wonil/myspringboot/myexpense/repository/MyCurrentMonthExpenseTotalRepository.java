package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyCurrentMonthExpenseTotal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyCurrentMonthExpenseTotalRepository extends JpaRepository<MyCurrentMonthExpenseTotal, String> {
}
