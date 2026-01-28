package kr.wonil.myspringboot.myinvest.data.dto;


import kr.wonil.myspringboot.util.NumberUtil;
import lombok.Data;
import org.json.simple.JSONObject;

import java.util.StringTokenizer;

@Data
public class StockDto {

    private String stockNumber;
    private String etfType;
    private String stockName;
    private Integer stockPrice;
    private String stockPriceDate;
    private Integer difference;
    private Double differenceRatio;
    private Long marketValue;
    private Long tradingAmount;

    private Double threeMonthEarnRate;
    private Double nav;
    private String etfFlag;


    public StockDto(JSONObject jsonObject) {

        try {

            etfType = jsonObject.get("etfTabCode") + "";
            stockName = jsonObject.get("itemname") + "";
            stockNumber = jsonObject.get("itemcode") + "";
            stockPrice = NumberUtil.parseInt(jsonObject.get("nowVal")+"");
            difference = NumberUtil.parseInt(jsonObject.get("changeVal") + "");
            differenceRatio = NumberUtil.parseDouble(jsonObject.get("changeRate") + "");
            threeMonthEarnRate = NumberUtil.parseDouble(jsonObject.get("threeMonthEarnRate") + "");
            tradingAmount = NumberUtil.parseLong(jsonObject.get("quant") + "");
            marketValue = NumberUtil.parseLong(jsonObject.get("marketSum") + "");
            nav = NumberUtil.parseDouble(jsonObject.get("nav") + "");
            etfFlag = "Y";

        }catch (Exception e){

        	System.err.println(e.toString());
			e.printStackTrace();

        }

        //System.out.println(toString());

    }



    public String getStockName() {

        if(stockName == null) return "-";
        return stockName;
    }
    
    private String getStockNumber(String str) {

        StringTokenizer st = new StringTokenizer(str, "\n");
        String stockNumberLine, rst;
        st.nextToken(); //Rank

        stockNumberLine = st.nextToken().replaceAll("\"", "");

        stockNumberLine = stockNumberLine.substring(stockNumberLine.indexOf("code="));
        StringTokenizer st2 = new StringTokenizer(stockNumberLine);
        rst = st2.nextToken().replace("code=", "");

        return rst;
    }

    public String getEtfFlag() {

        if(etfFlag == null) return "N";

        return etfFlag;
    }

}
