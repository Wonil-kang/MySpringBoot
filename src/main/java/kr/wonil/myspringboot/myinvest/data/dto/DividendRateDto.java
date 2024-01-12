package kr.wonil.myspringboot.myinvest.data.dto;


import kr.wonil.myspringboot.myinvest.data.entity.DividendRate;
import lombok.Data;

@Data
public class DividendRateDto {

    private String stockNumber;
    private String stockName;
    private String year;
    private int dividend;
    private int currentStockPrice;
    private int averageStockPrice;
    private double currentDividendRate;
    private double myDividendRate;

    public DividendRateDto(DividendRate dividendRate){

        stockNumber = dividendRate.getStockNumber();
        stockName = dividendRate.getStockName();
        year = dividendRate.getYear();
        dividend = dividendRate.getDividend();
        currentStockPrice = dividendRate.getCurrentStockPrice();
        averageStockPrice = dividendRate.getAverageStockPrice();
        currentDividendRate = dividendRate.getCurrentDividendRate();
        myDividendRate = dividendRate.getMyDividendRate();

    }

}
