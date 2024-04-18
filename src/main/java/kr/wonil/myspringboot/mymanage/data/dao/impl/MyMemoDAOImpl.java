package kr.wonil.myspringboot.mymanage.data.dao.impl;

import kr.wonil.myspringboot.mymanage.data.dao.MyAccountDAO;
import kr.wonil.myspringboot.mymanage.data.dao.MyMemoDAO;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import kr.wonil.myspringboot.mymanage.repository.MyAccountRepository;
import kr.wonil.myspringboot.mymanage.repository.MyAccountSampleRepository;
import kr.wonil.myspringboot.mymanage.repository.MyMemoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MyMemoDAOImpl implements MyMemoDAO {

    private final MyMemoRepository myMemoRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(MyMemoDAOImpl.class);

    public List<MyMemo> selectMyMemo() {

        List<MyMemo> list = myMemoRepository.findAll();

        return list;
    }

    public MyMemo selectMyMemoById(int memoId) {

        Optional<MyMemo> selectedEntity = myMemoRepository.findById(memoId);

        if(selectedEntity.isPresent()){

            return selectedEntity.get();
        }

        return null;
    }

    public MyMemo selectRandomMyMemo() {

        List<MyMemo> list = myMemoRepository.findRandomRecord();

        if(!list.isEmpty()){

            return list.getFirst();
        }
        return null;
    }

    public MyMemo updateMyMemo(MyMemo myMemo) {

        MyMemo result = null;

        try {

            result = myMemoRepository.save(myMemo);

        }catch(Exception e){
            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public MyMemo insertMyMemo(MyMemo myMemo) {

        MyMemo result = null;

        try {

            myMemo.setMemoId(null);
            result = myMemoRepository.save(myMemo);

        }catch(Exception e){
            LOGGER.error(e.toString());
            e.printStackTrace();
        }

        return result;
    }
}
