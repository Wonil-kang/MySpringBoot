package kr.wonil.myspringboot.myexpense.data.dto;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myexpense.data.entity.MyWeeklyExpenseTotal;
import lombok.Data;

@Data
public class MyWeeklyExpenseTotalDto  {

    private String year;
    private Integer weekNumber;
    private Integer transactionAmount;

    public MyWeeklyExpenseTotalDto(MyWeeklyExpenseTotal entity){

        this.year = entity.getYear();
        this.weekNumber = entity.getWeekNumber();
        this.transactionAmount = entity.getTransactionAmount();

    }

}
