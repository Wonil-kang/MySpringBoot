package kr.wonil.myspringboot.myinvest.controller;

import kr.wonil.myspringboot.myinvest.data.dto.*;
import kr.wonil.myspringboot.myinvest.service.MyInvestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/invest")
public class InvestController {

    private final MyInvestService myInvestService;

    /*
     * NO MORE USED 2025.9.9.
     *

    @GetMapping(value = "/total-base-point")
    public ResponseEntity<List<BasePointDto>> getTotalBasePoint(){

        List<BasePointDto> dtoList = myInvestService.getTotalBasePoint();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/coin/my-coin-price-flow")
    public ResponseEntity<List<MyCoinPriceFlowDto>> getMyCoinPriceFlow(){

        List<MyCoinPriceFlowDto> dtoList = myInvestService.getMyCoinPriceFlow();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

     */

    @GetMapping("/my-monthly-invest-total")
    public ResponseEntity<List<MyMonthlyInvestTotalDto>> getMyMonthlyInvestTotal(
            @RequestParam String month) {

        List<MyMonthlyInvestTotalDto> list = null;

        if(month == null || month.length() < 6)
            list =  myInvestService.getMyMonthlyInvestTotal();

        else
            list = myInvestService.getMyMonthlyInvestTotal(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-monthly-invest-amount")
    public ResponseEntity<List<MyMonthlyInvestAmountViewDto>> getMyMonthlyInvestAmount(
            @RequestParam String month) {

        List<MyMonthlyInvestAmountViewDto> list = null;

        if(month == null || month.length() < 6)
            list =  myInvestService.getMyMonthlyInvestAmount();

        else
            list = myInvestService.getMyMonthlyInvestAmount(month);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/my-yearly-invest-amount")
    public ResponseEntity<List<MyYearlyInvestAmountViewDto>> getMyYearlyInvestAmount(
            @RequestParam String year) {

        List<MyYearlyInvestAmountViewDto> list = null;

        if(year == null || year.length() < 4)
            list =  myInvestService.getMyYearlyInvestAmount();

        else
            list = myInvestService.getMyYearlyInvestAmount(year);

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/fx-status")
    public ResponseEntity<List<FxStatusDto>> getMyYearlyInvestAmount() {

        List<FxStatusDto> list = myInvestService.getFxStatus();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }


    @GetMapping("/total-finance-status")
    public ResponseEntity<List<TotalFinanceStatusDto>> getTotalFinanceStatus() {

        List<TotalFinanceStatusDto> list = myInvestService.getTotalFinanceStatus();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }


    @GetMapping("/yearly-snp-margin")
    public ResponseEntity<List<YearlyMarginDto>> getSnpYearlyMargin() {

        List<YearlyMarginDto> list = myInvestService.getSnpYearlyMargin();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/snp-yoy")
    public ResponseEntity<List<SnPYoYDto>> getSnpYoY() {

        List<SnPYoYDto> list = myInvestService.getSnpYoY();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/snp-price-to-top")
    public ResponseEntity<List<SnpPriceToTopDto>> getSnpPriceToTop() {

        List<SnpPriceToTopDto> list = myInvestService.getSnpPriceToTop();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/price-to-top")
    public ResponseEntity<List<PriceToTopDto>> getPriceToTop() {

        List<PriceToTopDto> list = myInvestService.getPriceToTop();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }


    @GetMapping("/my-invest-total-status")
    public ResponseEntity<List<MyInvestTotalStatusDto>> getMyInvestTotalStatus() {

        List<MyInvestTotalStatusDto> list = myInvestService.getMyInvestTotalStatus();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }
}
