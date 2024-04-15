package kr.wonil.myspringboot.myinvest.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.myspringboot.myinvest.data.entity.TotalFinanceStatus;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
public class TotalFinanceStatusDto {

    private int totalTradingAmount;
    private int actualTradingAmount;
    private int totalEstimateAmount;
    private int totalDividend;
    private double totalDividendRate;
    private int marginWithDividend;
    private int marginWithoutDividend;
    private double marginRateWithDividend;
    private double marginRateWithoutDividend;

    public TotalFinanceStatusDto(TotalFinanceStatus entity){


        totalTradingAmount = entity.getTotalTradingAmount();
        actualTradingAmount = entity.getActualTradingAmount();
        totalEstimateAmount = entity.getTotalEstimateAmount();
        totalDividend = entity.getTotalDividend();
        totalDividendRate = entity.getTotalDividendRate();
        marginWithDividend = entity.getMarginWithDividend();
        marginWithoutDividend = entity.getMarginWithoutDividend();
        marginRateWithDividend = entity.getMarginRateWithDividend();
        marginRateWithoutDividend = entity.getMarginRateWithoutDividend();

    }



}
