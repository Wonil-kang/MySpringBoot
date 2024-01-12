package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyExpenseByExpenseCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMonthlyExpenseByExpenseCodeRepository extends JpaRepository<MyMonthlyExpenseByExpenseCode, String> {


}
