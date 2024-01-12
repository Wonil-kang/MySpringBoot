package kr.wonil.myspringboot.myinvest.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class DividendRatePK implements Serializable {

        @Column(name = "stock_no")
        private String stockNumber;
        @Column(name = "year")
        private String year;
}
