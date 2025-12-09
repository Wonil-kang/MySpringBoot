package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.dto.StockDto;
import kr.wonil.myspringboot.myinvest.data.entity.pk.StockInfoPK;
import kr.wonil.myspringboot.myinvest.data.entity.pk.TotalStockInfoPK;
import kr.wonil.myspringboot.util.DateUtil;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@Table(name = "WS_STOCK_INFO_TB")
@IdClass(TotalStockInfoPK.class)
public class TotalStockInfo {
    @Id
    @Column(name = "STOCK_CODE")
    private String stockCode;

    @Column(name = "STOCK_NAME")
    private String stockName;

    @Column(name = "STOCK_PRICE")
    private BigInteger stockPrice;

    @Column(name = "DATE")
    private String date;

    @Column(name = "UPDATE_DT")
    private Date updateDate;

}
