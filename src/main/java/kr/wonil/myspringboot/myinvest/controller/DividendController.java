package kr.wonil.myspringboot.myinvest.controller;

import kr.wonil.myspringboot.myinvest.data.dto.DividendRateDto;
import kr.wonil.myspringboot.myinvest.service.DividendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dividend")
public class DividendController {

    private final DividendService dividendService;

    @Autowired
    public DividendController(DividendService dividendService) {
        this.dividendService = dividendService;
    }

    @GetMapping("/dividend-rate")
    public ResponseEntity<List<DividendRateDto>> getDividendRate() {

        List<DividendRateDto> dtoList = dividendService.getDividendRate();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }
}
