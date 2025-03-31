package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.myspringboot.myinvest.data.dto.MyStockHistoryDto;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "my_stock_history_tb")
@Data
public class MyStockHistory {

    @Id
    @Column(name = "STOCK_ID")
    private int stockId;
    @Column(name = "STOCK_NO")
    private String stockNumber;
    @Column(name = "STOCK_NAME")
    private String stockName;
    @Column(name = "RDTT")
    String rdtt;
    @Column(name = "MDTT")
    String mdtt;
    @Column(name = "REGR_ID")
    String registerId;
    @Column(name = "MODR_ID")
    String modifierId;
    @Column(name = "STOCK_TRADING_DATE")
    private String stockTradingDate;
    @Column(name = "STOCK_PRICE")
    private int stockPrice;
    @Column(name = "NUMBER_OF_STOCK")
    private int numberOfStock;
    @Column(name = "TOTAL_PRICE")
    private int totalPrice;
    @Column(name = "SMS_BODY", columnDefinition = "TEXT")
    private String smsBody;
    @Column(name = "SMS_ID")
    private int smsId;
    @Column(name = "USE_YN")
    private String useFlag;

    public MyStockHistory(MyStockHistoryDto dto){

        this.stockId = dto.getStockId();
        this.stockNumber = dto.getStockNumber();
        this.stockName = dto.getStockName();
        this.stockTradingDate = dto.getStockTradingDate();
        this.stockPrice = dto.getStockPrice();
        this.numberOfStock = dto.getNumberOfStock();
        this.totalPrice = dto.getTotalPrice();
        this.smsBody = dto.getSmsBody();
        this.smsId = dto.getSmsId();
        this.useFlag = dto.getUseFlag();

    }

    public MyStockHistory() {

    }
}
