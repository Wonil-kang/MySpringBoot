package kr.wonil.myspringboot.yahoofinance.controller;

import kr.wonil.test.myspringboot.yahoofinance.data.dto.FinancialIndicatorDto;
import kr.wonil.test.myspringboot.yahoofinance.data.dto.YahooDayInfoDataDto;
import kr.wonil.test.myspringboot.yahoofinance.service.YahooFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/yahoo-finance")
@RequiredArgsConstructor
public class YahooFinanceController {

    private final YahooFinanceService yahooFinanceService;


    @GetMapping("/recent-financial-indicators")
    public ResponseEntity<List<FinancialIndicatorDto>> getRecentFinancialIndicators() {

        List<FinancialIndicatorDto> dtoList = null;

        dtoList = yahooFinanceService.getRecentFinancialIndicators();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping("/yahoo-finance-day-info-data")
    public ResponseEntity<List<YahooDayInfoDataDto>> getYahooFinanceDayInfoData() {

        List<YahooDayInfoDataDto> dtoList = null;

        dtoList = yahooFinanceService.getYahooFinanceDayInfoData();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

}
