package kr.wonil.myspringboot.mymanage.mymanage.repository;

import kr.wonil.test.myspringboot.mymanage.data.entity.MyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyAccountRepository extends JpaRepository<MyAccount, Integer> {

    @Override
    @Query(value = "select * from MY_ACC_MNG_TB order by ACCOUNT_INFO, ACCOUNT"
            , nativeQuery = true)
    List<MyAccount> findAll();


}
