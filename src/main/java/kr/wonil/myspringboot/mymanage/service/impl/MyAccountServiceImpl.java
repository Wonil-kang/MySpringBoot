package kr.wonil.myspringboot.mymanage.service.impl;

import kr.wonil.myspringboot.mymanage.data.dao.MyAccountDAO;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountSampleDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import kr.wonil.myspringboot.mymanage.service.MyAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyAccountServiceImpl implements MyAccountService {

    private final MyAccountDAO myAccountDAO;


    @Override
    public List<MyAccountDto> getAllMyAccount() {

        List<MyAccountDto> dtoList = new ArrayList<>();
        List<MyAccount> entityList
                = myAccountDAO.selectMyAccount();

        MyAccountDto dto;

        for(MyAccount entity : entityList){

            dto = new MyAccountDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public List<MyAccountSampleDto> getMyAccountSample() {
        List<MyAccountSampleDto> dtoList = new ArrayList<>();
        List<MyAccountSample> entityList
                = myAccountDAO.selectMyAccountSample();

        MyAccountSampleDto dto;

        for(MyAccountSample entity : entityList){

            dto = new MyAccountSampleDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public MyAccountDto getMyAccountById(int accountId) {

        return new MyAccountDto(myAccountDAO.selectMyAccountById(accountId));
    }


    @Override
    public MyAccount saveMyAccount(MyAccountDto[] myDtoArr) {

        for(int i=0; i< myDtoArr.length; i++) {

            MyAccountDto dto = myDtoArr[i];

            MyAccount entity = new MyAccount(dto);
            MyAccount result = null;

            if(entity.getAccountId() > 0)
                result = myAccountDAO.updateMyAccount(entity);
            else
                result = myAccountDAO.insertMyAccount(entity);
        }
        return null;

    }

    @Override
    public MyAccount deleteMyAccount(MyAccountDto[] myDtoArr) {

        for(int i=0; i< myDtoArr.length; i++) {

            MyAccountDto dto = myDtoArr[i];

            MyAccount entity = new MyAccount(dto);
            myAccountDAO.deleteMyAccount(entity);
        }
        return null;

    }


}
