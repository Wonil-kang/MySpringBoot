package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyMonthlyInvestAmountView;
import lombok.Data;

@Data
public class MyMonthlyInvestAmountViewDto {

    private String month;
    private int amount;
    private int lastMonth;
    private int average3Month;
    private int average6Month;
    private int average12Month;

    public MyMonthlyInvestAmountViewDto(MyMonthlyInvestAmountView entity){

        month = entity.getMonth();
        amount = entity.getAmount();
        lastMonth = entity.getLastMonth();
        average3Month = entity.getAverage3Month();
        average6Month = entity.getAverage6Month();
        average12Month = entity.getAverage12Month();

    }

}
