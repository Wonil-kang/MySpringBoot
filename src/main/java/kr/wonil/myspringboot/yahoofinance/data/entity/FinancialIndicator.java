package kr.wonil.myspringboot.yahoofinance.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.yahoofinance.data.entity.pk.FinancialIndicatorPK;
import lombok.Data;

@Entity
@Table(name = "YAHOO_FINANCE_DATA_TB")
@IdClass(FinancialIndicatorPK.class)
@Data
public class FinancialIndicator {
    @Id
    @Column(name ="TICKER")
    private String ticker;
    @Column(name ="TICKER_NAME")
    private String tickerName;
    @Id
    @Column(name ="DATE")
    private String date;
    @Column(name ="HIGH")
    private double highPrice;
    @Column(name ="LOW")
    private double lowPrice;
    @Column(name ="OPEN")
    private double openingPrice;
    @Column(name ="CLOSE")
    private double closingPrice;
    @Column(name ="VOLUME")
    private double tradeVolume;
    @Column(name ="ADJ_CLOSE")
    private double adjustedClosingPrice;
}
