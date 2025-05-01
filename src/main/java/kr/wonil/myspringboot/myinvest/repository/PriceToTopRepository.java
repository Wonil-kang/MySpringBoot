package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.PriceToTop;
import kr.wonil.myspringboot.myinvest.data.entity.SnpPriceToTop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceToTopRepository extends JpaRepository<PriceToTop, String> {

}
