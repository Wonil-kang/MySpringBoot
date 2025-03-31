package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.MyStockHistory;
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

    public MyStockHistoryDto(){

        this.smsBody = "-";
        this.useFlag = "Y";

    }

    public void setStockTradingDate(String tradingDate) {

        if(tradingDate.length() == 12)
            tradingDate = tradingDate + "00";

        this.stockTradingDate = tradingDate;
    }
    public void setTotalTradingPrice() {

        try {

            totalPrice = numberOfStock * stockPrice;

        }catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }

    }

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
