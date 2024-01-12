package kr.wonil.myspringboot.yahoofinance.data.dto;

import kr.wonil.myspringboot.yahoofinance.data.entity.FinancialIndicator;
import lombok.Data;

@Data
public class FinancialIndicatorDto {
    private String ticker;
    private String tickerName;
    private String date;
    private double highPrice;
    private double lowPrice;
    private double openingPrice;
    private double closingPrice;
    private double tradeVolume;
    private double adjustedClosingPrice;

    public FinancialIndicatorDto(FinancialIndicator financialIndicator){

        ticker = financialIndicator.getTicker();
        tickerName = financialIndicator.getTickerName();
        date = financialIndicator.getDate();
        highPrice = financialIndicator.getHighPrice();
        lowPrice = financialIndicator.getLowPrice();
        openingPrice = financialIndicator.getOpeningPrice();
        closingPrice = financialIndicator.getClosingPrice();
        tradeVolume = financialIndicator.getTradeVolume();
        adjustedClosingPrice = financialIndicator.getAdjustedClosingPrice();

    }
}
