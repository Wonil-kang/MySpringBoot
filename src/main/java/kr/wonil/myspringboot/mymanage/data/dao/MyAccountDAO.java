package kr.wonil.myspringboot.mymanage.data.dao;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;

import java.util.List;

public interface MyAccountDAO {

    public List<MyAccount> selectMyAccount();

    public MyAccount insertMyAccount(MyAccount myAccount);

    public MyAccount updateMyAccount(MyAccount myAccount);

}
