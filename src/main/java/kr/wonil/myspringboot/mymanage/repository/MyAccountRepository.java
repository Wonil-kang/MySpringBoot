package kr.wonil.myspringboot.mymanage.repository;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyAccountRepository extends JpaRepository<MyAccount, String> {

    @Query(value = "select s from MySms s where s.smsDate > :date", nativeQuery = false)
    List<MySms> findMySmsByDate(String date);

    @Query(value = "select s from MySms s where s.smsDate = :date and s.sourceNumber = :sourceNumber", nativeQuery = false)
    List<MySms> findMySmsBySourceNumberAndSmsDate(String sourceNumber, String date);

    @Query(value = "select s from MySms s where s.smsLongDate = (select max (t.smsLongDate) from MySms t)", nativeQuery = false)
    List<MySms> findLatestMySms();

}
