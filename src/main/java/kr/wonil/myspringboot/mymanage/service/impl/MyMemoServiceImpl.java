package kr.wonil.myspringboot.mymanage.service.impl;

import kr.wonil.myspringboot.mymanage.data.dao.MyAccountDAO;
import kr.wonil.myspringboot.mymanage.data.dao.MyMemoDAO;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountSampleDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import kr.wonil.myspringboot.mymanage.service.MyAccountService;
import kr.wonil.myspringboot.mymanage.service.MyMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyMemoServiceImpl implements MyMemoService {


    private final MyMemoDAO myMemoDAO;


    @Override
    public List<MyMemoDto> getAllMyMemo() {

        List<MyMemoDto> dtoList = new ArrayList<>();
        List<MyMemo> entityList
                = myMemoDAO.selectMyMemo();

        MyMemoDto dto;

        for(MyMemo entity : entityList){

            dto = new MyMemoDto(entity);
            dtoList.add(dto);

        }

        return dtoList;
    }

    @Override
    public MyMemoDto getMyMemoById(int memoId) {

        return new MyMemoDto(myMemoDAO.selectMyMemoById(memoId));
    }

    @Override
    public MyMemoDto getRandomMyMemo() {

        return new MyMemoDto(myMemoDAO.selectRandomMyMemo());
    }

    @Override
    public MyMemo saveMyMemo(MyMemoDto[] dtoArr) {

        for(int i=0; i< dtoArr.length; i++) {

            MyMemoDto dto = dtoArr[i];

            MyMemo entity = new MyMemo(dto);
            MyMemo result = null;

            if(entity.getMemoId() != null && entity.getMemoId() > 0)
                result = myMemoDAO.updateMyMemo(entity);
            else
                result = myMemoDAO.insertMyMemo(entity);
        }
        return null;

    }
}
