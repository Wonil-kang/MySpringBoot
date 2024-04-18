package kr.wonil.myspringboot.mymanage.data.dao;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;

import java.util.List;

public interface MyAccountDAO {

    public List<MyAccount> selectMyAccount();

    public List<MyAccountSample> selectMyAccountSample();

    public MyAccount selectMyAccountById(int accountId);

    public MyAccount insertMyAccount(MyAccount myAccount);

    public void deleteMyAccount(MyAccount myAccount);

    public MyAccount updateMyAccount(MyAccount myAccount);


}
