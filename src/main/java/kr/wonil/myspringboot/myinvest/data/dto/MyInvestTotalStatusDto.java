package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyInvestTotalStatus;
import kr.wonil.myspringboot.util.DateUtil;
import kr.wonil.myspringboot.util.NumberUtil;
import lombok.Data;

@Data
public class MyInvestTotalStatusDto {

    private static final int TARGET_YEAR = 2033;
    private static final double INTEREST_RATE = 0.10;

    private String today;
    private Integer totalTradingAmount;
    private Integer actualTradingAmount;
    private Integer totalEstimateAmount;
    private Integer totalEstimateAmountAfter10Year;
    private Integer totalDividend;
    private Double totalDividendRate;
    private Integer marginWithoutDividend;
    private Double marginRateWithoutDividend;
    private Integer marginWithDividend;
    private Double marginRateWithDividend;

    public MyInvestTotalStatusDto(MyInvestTotalStatus entity){

        int numberOfYear = 0;

        today = entity.getToday();
        totalTradingAmount = entity.getTotalTradingAmount();
        actualTradingAmount = entity.getActualTradingAmount();
        totalEstimateAmount = entity.getTotalEstimateAmount();
        totalDividend = entity.getTotalDividend();
        totalDividendRate = entity.getTotalDividendRate();
        marginWithoutDividend = entity.getMarginWithoutDividend();
        marginRateWithoutDividend = entity.getMarginRateWithoutDividend();
        marginWithDividend = entity.getMarginWithDividend();
        marginRateWithDividend = entity.getMarginRateWithDividend();

        numberOfYear = TARGET_YEAR - NumberUtil.parseInt(DateUtil.getCurrentKoreanDate().substring(0,4));
        totalEstimateAmountAfter10Year = (int) NumberUtil.getCompoundInterest(totalEstimateAmount, INTEREST_RATE, numberOfYear);

    }

}
