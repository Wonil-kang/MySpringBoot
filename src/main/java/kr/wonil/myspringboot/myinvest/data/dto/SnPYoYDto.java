package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.SnPYoY;
import lombok.Data;

@Data
public class SnPYoYDto {


    private String tickerName;
    private String ticker;
    private String lastDate;
    private double lastClose;
    private String date;
    private double close;
    private double difference;
    private double differenceRatio;

    public SnPYoYDto(SnPYoY entity){
        tickerName = entity.getTickerName();
        ticker = entity.getTicker();
        lastDate = entity.getLastDate();
        lastClose = entity.getLastClose();
        date = entity.getDate();
        close = entity.getClose();
        difference = entity.getDifference();
        differenceRatio = entity.getDifferenceRatio();
    }

}
