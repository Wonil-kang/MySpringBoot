package kr.wonil.myspringboot.myinvest.data.dto;

import kr.wonil.myspringboot.myinvest.data.entity.FxStatus;
import lombok.Data;

@Data
public class FxStatusDto {

    private String transactionId;
    private String smsBody;
    private Double todayValue;
    private Double average1Month;
    private Double average3Month;
    private Double average6Month;
    private Double average1Year;
    private Double average3Year;
    private Double average5Year;
    private Double average10Year;
    private Double average1MonthRate;
    private Double average3MonthRate;
    private Double average6MonthRate;
    private Double average1YearRate;
    private Double average3YearRate;
    private Double average5YearRate;
    private Double average10YearRate;

    public  FxStatusDto(FxStatus entity){
        transactionId = entity.getTransactionId();
        smsBody = entity.getSmsBody();
        todayValue = entity.getTodayValue();
        average1Month = entity.getAverage1Month();
        average3Month = entity.getAverage3Month();
        average6Month = entity.getAverage6Month();
        average1Year = entity.getAverage1Year();
        average3Year = entity.getAverage3Year();
        average5Year = entity.getAverage5Year();
        average10Year = entity.getAverage10Year();

        average1MonthRate = (todayValue - average1Month) / average1Month * 100;
        average3MonthRate = (todayValue - average3Month) / average3Month * 100;
        average6MonthRate = (todayValue - average6Month) / average6Month * 100;
        average1YearRate = (todayValue - average1Year) / average1Year * 100;
        average3YearRate = (todayValue - average3Year) / average3Year * 100;
        average5YearRate = (todayValue - average5Year) / average5Year * 100;
        average10YearRate = (todayValue - average10Year) / average10Year * 100;

    }

}
