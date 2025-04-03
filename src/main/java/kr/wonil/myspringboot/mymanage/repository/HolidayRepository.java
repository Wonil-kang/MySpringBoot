package kr.wonil.myspringboot.mymanage.repository;

import kr.wonil.myspringboot.mymanage.data.entity.Holiday;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, String> {


}
