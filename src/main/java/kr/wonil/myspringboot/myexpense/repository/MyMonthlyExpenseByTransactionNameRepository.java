package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthExpenseByTransactionName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyMonthlyExpenseByTransactionNameRepository extends JpaRepository<MyMonthExpenseByTransactionName, String> {

    List<MyMonthExpenseByTransactionName> findByMonth(String month);

}
