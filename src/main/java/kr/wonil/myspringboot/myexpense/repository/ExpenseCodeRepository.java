package kr.wonil.myspringboot.myexpense.repository;

import kr.wonil.myspringboot.myexpense.data.entity.ExpenseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseCodeRepository extends JpaRepository<ExpenseCode, Integer> {


    List<ExpenseCode> findAllByOrderByRecentUsedDateDesc();

//    @Query(value = "select et from ExpenseCode et where et.expenseCode in " +
//            "(select distinct t.expenseCode from MyTransactionView t where t.transactionInfo=:transactionInfo)"
//    , nativeQuery = false)
//    List<ExpenseCode> selectExpenseCodesByTransactionInfo(@Param("transactionInfo") String transactionInfo);

    @Query(value = "" +
            "WITH CODE_STAT AS" +
            "   (select t.transaction_info, ect.EXPENSE_CODE, count(ect.EXPENSE_CODE) as cnt from expense_code_tb ect, my_Transaction_tb t" +
            "       where 1=1" +
            "       and ect.EXPENSE_CODE = t.EXPENSE_CODE" +
            "       group by ect.EXPENSE_CODE, t.transaction_info" +
            "       order by transaction_info, cnt desc)" +
            "select TT.*" +
            "    from expense_code_tb TT, CODE_STAT CS" +
            "    where 1=1" +
            "    AND TT.EXPENSE_CODE = CS.EXPENSE_CODE" +
            "    AND CS.transaction_info = :transactionInfo" +
            "    order by cnt desc"
            , nativeQuery = true)
    List<ExpenseCode> selectExpenseCodesByTransactionInfo(@Param("transactionInfo") String transactionInfo);




    @Query(value = "" +
            "WITH CODE_STAT AS" +
            "   (select t.transaction_info, ect.EXPENSE_CODE, count(ect.EXPENSE_CODE) as cnt from expense_code_tb ect, my_Transaction_tb t" +
            "       where 1=1" +
            "       and ect.EXPENSE_CODE = t.EXPENSE_CODE" +
            "       group by ect.EXPENSE_CODE, t.transaction_info" +
            "       order by transaction_info, cnt desc)" +
            "select TT.*" +
            "    from expense_code_tb TT, CODE_STAT CS" +
            "    where 1=1" +
            "    AND TT.EXPENSE_CODE = CS.EXPENSE_CODE" +
            "    AND CS.transaction_info = (select transaction_info from my_Transaction_tb where transaction_id = :transactionId)" +
            "    order by cnt desc"
            , nativeQuery = true)
    List<ExpenseCode> selectExpenseCodesByTransactionId(@Param("transactionId") String transactionId);


    // @Query(value = "SELECT u FROM User u WHERE u.name IN :names")
    // List<User> findUserByNameList(@Param("names") Collection<String> names);


    @Query(value = "select * from expense_code_tb" +
            " where use_yn = 'Y'" +
            " order by expense_code asc"
            , nativeQuery = true)
    List<ExpenseCode> findAll();

}
