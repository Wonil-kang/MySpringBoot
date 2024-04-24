package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.SnpPriceToTop;
import lombok.Data;

@Data
public class SnpPriceToTopDto {

    private Integer maxPrice;
    private Integer currentPrice;
    private Integer difference;
    private Double differenceRatio;

    public SnpPriceToTopDto(SnpPriceToTop entity){

        maxPrice = entity.getMaxPrice();
        currentPrice = entity.getCurrentPrice();
        difference = entity.getDifference();
        differenceRatio = entity.getDifferenceRatio();

    }

}
