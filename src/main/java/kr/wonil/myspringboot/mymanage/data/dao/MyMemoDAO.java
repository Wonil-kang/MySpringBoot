package kr.wonil.myspringboot.mymanage.data.dao;

import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;

import java.util.List;

public interface MyMemoDAO {

    public List<MyMemo> selectMyMemo();
    public MyMemo selectMyMemoById(int memoId);

    public MyMemo selectRandomMyMemo();

    public MyMemo insertMyMemo(MyMemo myMemo);

    public MyMemo updateMyMemo(MyMemo myMemo);

}
