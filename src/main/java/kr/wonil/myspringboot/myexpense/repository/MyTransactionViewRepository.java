package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyTransactionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyTransactionViewRepository extends JpaRepository<MyTransactionView, String> {

    List<MyTransactionView> findByDateTimeStartsWithOrderByDateTimeDesc(String month);

    List<MyTransactionView> findAllByTransactionInfoLikeAndExpenseCodeNotOrderByDateTimeDesc(String transactionIfo, String expenseCode);


    @Query(value = "select mt from MyTransactionView mt " +
            "   where mt.expenseCode = :expenseCode " +
            "       and mt.dateTime like :date%" +
            "   order by mt.transactionAmount desc"
            , nativeQuery = false)
    List<MyTransactionView> findAllByExpenseCodeAndDateTime(String expenseCode, String date);


    @Query(value = "select mt from MyTransactionView mt " +
            "   where mt.expenseCode = :expenseCode " +
            "   order by mt.dateTime desc"
            , nativeQuery = false)
    List<MyTransactionView> findAllByExpenseCode(String expenseCode);



    @Query(value = "select mt from MyTransactionView mt " +
            "   where mt.useFlag = 'Y'" +
            "       and mt.canceledTransactionId = '-'" +
            "       and mt.currency = 'KRW'" +
            "       and mt.dateTime like :date%" +
            "   order by mt.dateTime desc"
            , nativeQuery = false)
    List<MyTransactionView> findAllByDateTime(String date);




    @Query(value = "select mt from MyTransactionView mt " +
            "   where mt.expenseCode like :expenseCode% " +
            "       and mt.useFlag = 'Y'" +
            "       and mt.canceledTransactionId = '-'" +
            "       and mt.currency = 'KRW'" +
            "       and mt.dateTime like :date%" +
            "   order by mt.dateTime desc"
            , nativeQuery = false)
    List<MyTransactionView> findAllByCategoryCodeAndDateTime(String expenseCode, String date);

    @Query(value = "select * from MY_TRANSACTION_WITH_EXPENSE_CODE_VIEW" +
            " where 1=1" +
            " and expense_code = '-'" +
            " and use_yn = 'Y'" +
            " and CANCELED_TRANSACTION_ID = '-'" +
            " and CURRENCY = 'KRW'" +
            " and substr(date_time,1,8) >= date_format(date_sub(now(), interval 1 year), '%Y%m%d')" +
            " order by date_time desc;"
            , nativeQuery = true)
    List<MyTransactionView> findAllMyUncheckedTransaction();

    @Query(value = "select mt from MyTransactionView mt " +
            "   where mt.useFlag = 'Y'" +
            "       and mt.canceledTransactionId = '-'" +
            "       and (mt.transactionInfo like %:transactionInfo%" +
            "       OR mt.memo like %:memo%)" +
            "   order by mt.dateTime desc"
            , nativeQuery = false)
    List<MyTransactionView> findAllByTransactionInfoContainingOrMemoContainingOrderByDateTimeDesc(String transactionInfo, String memo);

}
