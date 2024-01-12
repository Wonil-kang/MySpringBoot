package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyExpenseByCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMonthlyExpenseByCategoryRepository extends JpaRepository<MyMonthlyExpenseByCategory, String> {


}
