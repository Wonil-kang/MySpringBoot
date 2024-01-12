package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyTargetExpenseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyMonthlyTargetExpenseStatusRepository extends JpaRepository<MyMonthlyTargetExpenseStatus, String> {

    List<MyMonthlyTargetExpenseStatus> getAllByMonth(String month);
}
