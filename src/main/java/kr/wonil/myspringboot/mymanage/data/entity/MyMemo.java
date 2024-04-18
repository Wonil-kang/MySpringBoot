package kr.wonil.myspringboot.mymanage.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import lombok.Data;


@Entity
@Table(name = "MY_MEMO_TB")
@Data
public class MyMemo {

    @Id
    @Column(name = "memo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memoId;
    @Column(name = "memo")
    private String memo;
    @Column(name = "memo_source")
    private String memoSource;
    @Column(name = "date_time")
    private String dateTime;
    @Column(name = "use_yn")
    private String useFlag;

    public MyMemo(MyMemoDto dto){
        memoId = dto.getMemoId();
        memo = dto.getMemo();
        memoSource = dto.getMemoSource();
        dateTime = dto.getDateTime();
        useFlag = dto.getUseFlag();
    }

    public MyMemo() {
        
    }
}
