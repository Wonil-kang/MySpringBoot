package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyTransactionRepository extends JpaRepository<MyTransaction, Integer> {

    List<MyTransaction> findAllByExpenseCodeOrderByDateTimeDesc(String expenseCode);



}
