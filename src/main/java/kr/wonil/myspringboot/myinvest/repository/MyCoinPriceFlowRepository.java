package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyCoinPriceFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCoinPriceFlowRepository extends JpaRepository<MyCoinPriceFlow, String> {

}
