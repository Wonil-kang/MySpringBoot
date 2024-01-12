package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyYearlyInvestAmountView;
import lombok.Data;

@Data
public class MyYearlyInvestAmountViewDto {

    private String year;
    private int amount;

    public MyYearlyInvestAmountViewDto(MyYearlyInvestAmountView entity){

        year = entity.getYear();
        amount = entity.getAmount();

    }

}
