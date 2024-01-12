package kr.wonil.myspringboot.yahoofinance.data.dto;

import kr.wonil.myspringboot.yahoofinance.data.entity.YahooDayInfoData;
import lombok.Data;

@Data
public class YahooDayInfoDataDto {
    private String ticker;
    private String tickerName;
    private double close;
    private double difference;
    private double differenceRate;



    public YahooDayInfoDataDto(YahooDayInfoData entity){

        ticker = entity.getTicker();
        tickerName = entity.getTickerName();
        close = entity.getClose();
        difference = entity.getDifference();
        differenceRate = entity.getDifferenceRate();

        if(ticker.equals("JPYKRW=X")){
            close = close * 100;
            difference = difference * 100;
        }

    }
}
