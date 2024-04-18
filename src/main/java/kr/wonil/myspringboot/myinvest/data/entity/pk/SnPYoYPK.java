package kr.wonil.myspringboot.myinvest.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class SnPYoYPK implements Serializable {

        @Column(name = "ticker")
        private String ticker;
        @Column(name = "last_date")
        private String lastDate;
}
