package kr.wonil.myspringboot.myexpense.data.dto;

import kr.wonil.test.myspringboot.myexpense.data.entity.MyMonthlyTargetExpenseStatus;
import lombok.Data;

@Data
public class MyMonthlyTargetExpenseStatusDto {

    private String month;
    private Integer numberOfDays;
    private Integer underHalfTargetNumber;
    private Integer underTargetNumber;
    private Integer upperTargetNumber;
    private Integer upperDoubleTargetNumber;
    private Double underHalfTargetRate;
    private Double underTargetRate;
    private Double upperTargetRate;
    private Double upperDoubleTargetRate;

    public MyMonthlyTargetExpenseStatusDto(MyMonthlyTargetExpenseStatus entity){

        month = entity.getMonth();
        numberOfDays = entity.getNumberOfDays();
        underHalfTargetNumber = entity.getUnderHalfTargetNumber();
        underTargetNumber = entity.getUnderTargetNumber();
        upperTargetNumber = entity.getUpperTargetNumber();
        upperDoubleTargetNumber = entity.getUpperDoubleTargetNumber();
        underHalfTargetRate = entity.getUnderHalfTargetRate();
        underTargetRate = entity.getUnderTargetRate();
        upperTargetRate = entity.getUpperTargetRate();
        upperDoubleTargetRate = entity.getUpperDoubleTargetRate();
    }

}
