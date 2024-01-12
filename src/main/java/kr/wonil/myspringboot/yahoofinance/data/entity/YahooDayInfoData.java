package kr.wonil.myspringboot.yahoofinance.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "YAHOO_FINANCE_DAY_INFO_VIEW")
@Data
public class YahooDayInfoData {
    @Id
    @Column(name ="ticker")
    private String ticker;
    @Column(name ="ticker_name")
    private String tickerName;
    @Column(name ="close")
    private double close;
    @Column(name ="diff")
    private double difference;
    @Column(name ="diff_rate")
    private double differenceRate;
}
