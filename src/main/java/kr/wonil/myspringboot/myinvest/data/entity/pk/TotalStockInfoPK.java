package kr.wonil.myspringboot.myinvest.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class TotalStockInfoPK implements Serializable {

        @Column(name = "STOCK_CODE")
        private String stockCode;

        @Column(name = "DATE")
        private String date;
}
