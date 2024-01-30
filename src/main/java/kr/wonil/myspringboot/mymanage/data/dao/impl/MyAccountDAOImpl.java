package kr.wonil.myspringboot.mymanage.data.dao.impl;

import kr.wonil.myspringboot.mymanage.data.dao.MyAccountDAO;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import kr.wonil.myspringboot.mymanage.repository.MyAccountRepository;
import kr.wonil.myspringboot.mymanage.repository.MyAccountSampleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MyAccountDAOImpl implements MyAccountDAO {

    private final MyAccountRepository myAccountRepository;
    private final MyAccountSampleRepository myAccountSampleRepository;
    private Logger LOGGER = LoggerFactory.getLogger(MyAccountDAOImpl.class);

    @Override
    public List<MyAccount> selectMyAccount() {

        List<MyAccount> list = myAccountRepository.findAll();

        return list;
    }

    @Override
    public List<MyAccountSample> selectMyAccountSample() {

        List<MyAccountSample> list = myAccountSampleRepository.findAll();

        return list;
    }

    @Override
    public MyAccount selectMyAccountById(int accountId) {

        Optional<MyAccount> selectedEntity = myAccountRepository.findById(accountId);

        if(selectedEntity.isPresent()){

            return selectedEntity.get();
        }

        return null;
    }

    @Override
    public MyAccount insertMyAccount(MyAccount myAccount) {

        MyAccount result = null;

        try {

            result = myAccountRepository.save(myAccount);

        }catch(Exception e){

            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public MyAccount updateMyAccount(MyAccount myAccount) {

        MyAccount result = null;

        try {

            result = myAccountRepository.save(myAccount);

        }catch(Exception e){

            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public void deleteMyAccount(MyAccount myAccount) {


        try {
            myAccountRepository.delete(myAccount);

        }catch(Exception e){

            LOGGER.error(e.toString());
            e.printStackTrace();
        }

    }
}
