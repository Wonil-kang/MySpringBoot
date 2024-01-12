package kr.wonil.myspringboot.myinvest.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyCoinPriceFlowPK implements Serializable {

    @Column(name = "currency")
    private String currency;
    @Column(name = "timestamp")
    private String timestamp;
}
