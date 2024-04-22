package kr.wonil.myspringboot.mymanage.repository;

import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyMemoRepository extends JpaRepository<MyMemo, Integer> {

    @Override
    @Query(value = "select * from MY_MEMO_TB"
            , nativeQuery = true)
    List<MyMemo> findAll();

    @Query(value = "select * from MY_MEMO_TB where use_yn = 'Y' order by rand() limit 1"
            , nativeQuery = true)
    List<MyMemo> findRandomRecord();

}
