package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.test.myspringboot.myinvest.data.entity.BasePoint;
import lombok.Data;

@Data
public class BasePointDto {
    private String type;
    private int oneDayAgo;
    private int oneWeekAgo;
    private int oneMonthAgo;
    private int threeMonthAgo;
    private int halfYearAgo;
    private int oneYearAgo;

    public BasePointDto(BasePoint basePoint){

        type = basePoint.getType();
        oneDayAgo = basePoint.getOneDayAgo();
        oneWeekAgo = basePoint.getOneWeekAgo();
        oneMonthAgo = basePoint.getOneMonthAgo();
        threeMonthAgo = basePoint.getThreeMonthAgo();
        halfYearAgo = basePoint.getHalfYearAgo();
        oneYearAgo = basePoint.getOneYearAgo();


    }
}
