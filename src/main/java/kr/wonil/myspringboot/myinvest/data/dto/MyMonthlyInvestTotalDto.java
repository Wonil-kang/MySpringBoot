package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyMonthlyInvestTotal;
import lombok.Data;

@Data
public class MyMonthlyInvestTotalDto {

    private String month;
    private int investAmount;

    public MyMonthlyInvestTotalDto(MyMonthlyInvestTotal entity) {

        month = entity.getMonth();
        investAmount = entity.getInvestAmount();

    }
}
