package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.PriceToTop;
import kr.wonil.myspringboot.myinvest.data.entity.SnpPriceToTop;
import lombok.Data;

@Data
public class PriceToTopDto {

    private String stockNumber;
    private Integer maxPrice;
    private Integer currentPrice;
    private Integer difference;
    private Double differenceRatio;

    public PriceToTopDto(PriceToTop entity){

        stockNumber = entity.getStockNumber();
        maxPrice = entity.getMaxPrice();
        currentPrice = entity.getCurrentPrice();
        difference = entity.getDifference();
        differenceRatio = entity.getDifferenceRatio();

    }

}
