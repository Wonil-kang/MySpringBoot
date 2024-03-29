package kr.wonil.myspringboot.mymanage.repository;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyAccountRepository extends JpaRepository<MyAccount, Integer> {

    @Override
    @Query(value = "select * from MY_ACC_MNG_TB order by ACCOUNT_INFO, ACCOUNT"
            , nativeQuery = true)
    List<MyAccount> findAll();


}
