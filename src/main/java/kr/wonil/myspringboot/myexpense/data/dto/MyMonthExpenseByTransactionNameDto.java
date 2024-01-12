package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.myspringboot.myexpense.data.entity.MyMonthExpenseByTransactionName;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyMonthExpenseByTransactionNameDto implements Serializable {

    private String month;
    private String transactionInfo;
    private Integer amount;
    private Integer average1Month;
    private Integer average3Month;
    private Integer average6Month;
    private Integer average12Month;

    public MyMonthExpenseByTransactionNameDto(MyMonthExpenseByTransactionName entity){

        month = entity.getMonth();
        transactionInfo = entity.getTransactionInfo();
        amount = entity.getAmount();
        average1Month = entity.getAverage1Month();
        average3Month = entity.getAverage3Month();
        average6Month = entity.getAverage6Month();
        average12Month = entity.getAverage12Month();

    }

}
