package kr.wonil.myspringboot.mymanage.mymanage.data.dao;

import kr.wonil.test.myspringboot.mymanage.data.entity.MyAccount;

import java.util.List;

public interface MyAccountDAO {

    public List<MyAccount> selectMyAccount();

    public MyAccount selectMyAccountById(int accountId);

    public MyAccount insertMyAccount(MyAccount myAccount);

    public MyAccount updateMyAccount(MyAccount myAccount);

}
