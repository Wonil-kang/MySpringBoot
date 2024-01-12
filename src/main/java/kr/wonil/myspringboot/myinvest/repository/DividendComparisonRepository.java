package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.DividendRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendComparisonRepository extends JpaRepository<DividendRate, String> {

}
