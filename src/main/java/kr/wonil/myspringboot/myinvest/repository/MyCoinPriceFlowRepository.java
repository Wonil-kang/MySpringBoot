package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MyCoinPriceFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCoinPriceFlowRepository extends JpaRepository<MyCoinPriceFlow, String> {

}
