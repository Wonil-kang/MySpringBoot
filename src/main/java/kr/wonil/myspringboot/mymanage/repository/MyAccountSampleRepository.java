package kr.wonil.myspringboot.mymanage.repository;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyAccountSampleRepository extends JpaRepository<MyAccountSample, String> {



}
