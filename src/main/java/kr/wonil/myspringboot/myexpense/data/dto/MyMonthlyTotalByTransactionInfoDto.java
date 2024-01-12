package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthlyTotalByTransactionInfo;
import lombok.Data;

@Data
public class MyMonthlyTotalByTransactionInfoDto{

    private String month;
    private String transactionInfo;
    private int amount;
    private int lastMonth;
    private int average3Month;
    private int average6Month;
    private int average12Month;


    public MyMonthlyTotalByTransactionInfoDto(MyMonthlyTotalByTransactionInfo entity){

        month = entity.getMonth();
        transactionInfo = entity.getTransactionInfo();
        amount = entity.getAmount();
        lastMonth = entity.getLastMonth();
        average3Month = entity.getAverage3Month();
        average6Month = entity.getAverage6Month();
        average12Month = entity.getAverage12Month();

    }

}
