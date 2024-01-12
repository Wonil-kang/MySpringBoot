package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyDailyExpense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyDailyExpenseRepository extends JpaRepository<MyDailyExpense, String> {

    List<MyDailyExpense> findAllByDateStartsWith(String date);


    @Query(value = "select t from MyDailyExpense t " +
            "order by t.date desc ", nativeQuery = false)
    Page<MyDailyExpense> findTopN( Pageable pageable);

}
