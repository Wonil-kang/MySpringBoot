package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyExpenseByCategory;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyMonthlyExpenseByCategoryDto implements Serializable {

    private String month;
    private String categoryCode;
    private String categoryName;
    private Integer amount;

    public MyMonthlyExpenseByCategoryDto(MyMonthlyExpenseByCategory entity){

        this.month = entity.getMonth();
        this.categoryCode = entity.getCategoryCode();
        this.categoryName = entity.getCategoryName();
        this.amount = entity.getAmount();

    }
}
