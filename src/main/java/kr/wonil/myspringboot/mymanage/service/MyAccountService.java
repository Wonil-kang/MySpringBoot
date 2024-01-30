package kr.wonil.myspringboot.mymanage.service;

import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountSampleDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;

import java.util.List;

public interface MyAccountService {

    public List<MyAccountDto> getAllMyAccount();

    public List<MyAccountSampleDto> getMyAccountSample();

    public MyAccountDto getMyAccountById(int accountId);

    public MyAccount saveMyAccount(MyAccountDto[] myDtoArr);

    public MyAccount deleteMyAccount(MyAccountDto[] myDtoArr);

}
