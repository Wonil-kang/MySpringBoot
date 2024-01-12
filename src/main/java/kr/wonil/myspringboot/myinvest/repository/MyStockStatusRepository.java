package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.MyStockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyStockStatusRepository extends JpaRepository<MyStockStatus, String> {

}


