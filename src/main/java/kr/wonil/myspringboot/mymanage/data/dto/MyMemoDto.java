package kr.wonil.myspringboot.mymanage.data.dto;

import kr.wonil.myspringboot.mymanage.data.entity.MyMemo;
import lombok.Data;

@Data
public class MyMemoDto {

    private Integer memoId;
    private String memo;
    private String memoSource;
    private String dateTime;
    private String useFlag;

    public MyMemoDto(MyMemo entity){
        memoId = entity.getMemoId();
        memo = entity.getMemo();
        memoSource = entity.getMemoSource();
        dateTime = entity.getDateTime();
        useFlag = entity.getUseFlag();
    }

}
