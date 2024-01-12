package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyStockPriceFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyStockPriceFlowRepository extends JpaRepository<MyStockPriceFlow, String> {

}
