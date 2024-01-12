package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MyInvestTotalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyInvestTotalStatusRepository extends JpaRepository<MyInvestTotalStatus, String> {

}
