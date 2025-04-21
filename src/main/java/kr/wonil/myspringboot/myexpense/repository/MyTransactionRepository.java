package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.MyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MyTransactionRepository extends JpaRepository<MyTransaction, Integer> {

    List<MyTransaction> findAllByExpenseCodeOrderByDateTimeDesc(String expenseCode);


    @Modifying
    @Transactional
    @Query(value = "UPDATE my_transaction_tb " +
            "SET USE_YN = 'N', " +
            "CANCELED_TRANSACTION_ID = :cancelId " +
            "WHERE transaction_id = ( " +
            "   SELECT MAX(transaction_id) " +
            "   FROM ( " +
            "       SELECT transaction_id " +
            "       FROM my_transaction_tb " +
            "       WHERE transaction_info = :transactionInfo " +
            "         AND transaction_amount = :transactionAmount " +
            "         AND USE_YN = 'Y' " +
            "         AND CANCELED_TRANSACTION_ID = '-' " +
            "   ) AS sub " +
            ")",
            nativeQuery = true)
    int cancelInfoUpdate(@Param("cancelId") Integer cancelId,
                         @Param("transactionInfo") String transactionInfo,
                         @Param("transactionAmount") Integer transactionAmount);



}
