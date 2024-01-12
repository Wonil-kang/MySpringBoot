package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.FxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FxStatusRepository extends JpaRepository<FxStatus, Integer> {

}
