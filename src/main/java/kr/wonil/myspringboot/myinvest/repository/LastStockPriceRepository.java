package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.LastStockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastStockPriceRepository extends JpaRepository<LastStockPrice, String> {

}
