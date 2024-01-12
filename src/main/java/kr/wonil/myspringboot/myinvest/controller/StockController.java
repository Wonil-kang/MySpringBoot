package kr.wonil.myspringboot.myinvest.controller;

import kr.wonil.myspringboot.myinvest.data.dto.*;
import kr.wonil.myspringboot.myinvest.service.DividendService;
import kr.wonil.myspringboot.myinvest.service.MyStockService;
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
@RequestMapping("/stock")
public class StockController {

    private final MyStockService myStockService;
    private final DividendService dividendService;


    @GetMapping(value = "/my-stock-status/all")
    public ResponseEntity<List<MyStockStatusDto>> getMyStockStatus(){

        List<MyStockStatusDto> dtoList = myStockService.getAllMyStockStatus();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/my-stock-price-flow")
    public ResponseEntity<List<MyStockPriceFlowDto>> getMyStockPriceFlow(){

        List<MyStockPriceFlowDto> dtoList = myStockService.getMyStockPriceFlow();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/last-stock-price")
    public ResponseEntity<List<LastStockPriceDto>> getLastStockPrice(){

        List<LastStockPriceDto> dtoList = myStockService.getLastStockPrice();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/dividend-rate")
    public ResponseEntity<List<DividendRateDto>> getDividendRate(){

        List<DividendRateDto> dtoList = dividendService.getDividendRate();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/my-stock_history")
    public ResponseEntity<List<MyStockHistoryDto>> getMyStockHistories(
            @RequestParam String stockNumber,
            @RequestParam int limit){

        List<MyStockHistoryDto> dtoList = null;

        if(stockNumber == null || stockNumber.length() < 6)
            dtoList = myStockService.getMyStockHistories(limit);
        else
            dtoList = myStockService.getMyStockHistoriesByStockNumber(stockNumber, limit);

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }
}
