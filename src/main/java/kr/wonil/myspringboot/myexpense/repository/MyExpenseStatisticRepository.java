package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyExpenseStatistic;
import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseByExpenseCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyExpenseStatisticRepository extends JpaRepository<MyExpenseStatistic, String> {


}
