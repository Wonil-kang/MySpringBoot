package kr.wonil.myspringboot.yahoofinance.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class FinancialIndicatorPK implements Serializable {

    @Column(name = "TICKER")
    private String ticker;
    @Column(name ="DATE")
    private String date;

}
