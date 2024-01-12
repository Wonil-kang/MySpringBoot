package kr.wonil.myspringboot.myinvest.repository;

import kr.wonil.myspringboot.myinvest.data.entity.BasePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasePointRepository extends JpaRepository<BasePoint, String> {

}
