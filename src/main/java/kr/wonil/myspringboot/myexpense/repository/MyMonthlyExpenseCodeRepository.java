package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyExpenseCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyMonthlyExpenseCodeRepository extends JpaRepository<MyMonthlyExpenseCode, String> {

    List<MyMonthlyExpenseCode> findByMonth(String month);

    List<MyMonthlyExpenseCode> findByMonthOrderBySumDesc(String month);

}
