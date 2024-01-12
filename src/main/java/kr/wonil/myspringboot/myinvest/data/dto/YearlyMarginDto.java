package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.YearlyMargin;
import lombok.Data;

@Data
public class YearlyMarginDto {

    private String stockNumber;
    private String year;
    private int initialPrice;
    private int lastPrice;
    private int difference;
    private double differenceRatio;


    public YearlyMarginDto(YearlyMargin entity){

        stockNumber = entity.getStockNumber();
        year = entity.getYear();
        initialPrice = entity.getInitialPrice();
        lastPrice = entity.getLastPrice();
        difference = entity.getDifference();
        differenceRatio = entity.getDifferenceRatio();

    }

}
