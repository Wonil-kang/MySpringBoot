package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthExpenseExpect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMonthExpenseExpectRepository extends JpaRepository<MyMonthExpenseExpect, Integer> {


}
