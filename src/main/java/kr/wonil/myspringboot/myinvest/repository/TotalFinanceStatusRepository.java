package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.FxStatus;
import kr.wonil.myspringboot.myinvest.data.entity.TotalFinanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalFinanceStatusRepository extends JpaRepository<TotalFinanceStatus, Integer> {

}
