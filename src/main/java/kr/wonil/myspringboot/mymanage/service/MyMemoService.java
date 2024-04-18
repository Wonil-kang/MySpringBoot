package kr.wonil.myspringboot.mymanage.service;

import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountSampleDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;

import java.util.List;

public interface MyMemoService {

    public List<MyMemoDto> getAllMyMemo();
    public MyMemoDto getMyMemoById(int memoId);
    public MyMemoDto getRandomMyMemo();
    public MyMemo saveMyMemo(MyMemoDto[] dtoArr);
}
