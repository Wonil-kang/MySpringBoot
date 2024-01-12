package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.test.myspringboot.myinvest.data.entity.MyStockHistory;
import lombok.Data;

@Data
public class MyStockHistoryDto {

    private int stockId;
    private String stockNumber;
    private String stockName;
    private String stockTradingDate;
    private int stockPrice;
    private int numberOfStock;
    private int totalPrice;
    private String smsBody;
    private int smsId;
    private String useFlag;

    public MyStockHistoryDto(MyStockHistory myStockHistory) {

        stockNumber = myStockHistory.getStockNumber();
        stockName = myStockHistory.getStockName();
        stockId = myStockHistory.getStockId();
        stockNumber = myStockHistory.getStockNumber();
        stockName = myStockHistory.getStockName();
        stockTradingDate = myStockHistory.getStockTradingDate();
        stockPrice = myStockHistory.getStockPrice();
        numberOfStock = myStockHistory.getNumberOfStock();
        totalPrice = myStockHistory.getTotalPrice();
        smsBody = myStockHistory.getSmsBody();
        smsId = myStockHistory.getSmsId();
        useFlag = myStockHistory.getUseFlag();
    }
}
