package kr.wonil.myspringboot.mymanage.service;

import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;

import java.util.List;

public interface MyAccountService {

    public List<MyAccountDto> getAllMyAccount();

    public MyAccountDto getMyAccountById(int accountId);

    public MyAccount saveMyAccount(MyAccountDto[] myDtoArr);

}
