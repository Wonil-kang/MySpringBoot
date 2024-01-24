package kr.wonil.myspringboot.mymanage.mymanage.service;

import kr.wonil.test.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.test.myspringboot.mymanage.data.entity.MyAccount;

import java.util.List;

public interface MyAccountService {

    public List<MyAccountDto> getAllMyAccount();

    public MyAccountDto getMyAccountById(int accountId);

    public MyAccount saveMyAccount(MyAccountDto[] myDtoArr);

}
