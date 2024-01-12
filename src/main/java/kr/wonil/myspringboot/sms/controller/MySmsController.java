package kr.wonil.myspringboot.sms.controller;

import kr.wonil.test.myspringboot.sms.data.dto.MySmsDto;
import kr.wonil.test.myspringboot.sms.service.MySmsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-sms")
@RequiredArgsConstructor
public class MySmsController {

    private Logger LOGGER = LoggerFactory.getLogger(MySmsController.class);
    private final MySmsService mySmsService;


    @GetMapping("/my-sms-by-date")
    public ResponseEntity<List<MySmsDto>> getMySmsByDate(
            @RequestParam String date) {

        List<MySmsDto> dtoList = null;

        if(date == null || date.length() < 8)
            dtoList = mySmsService.getMySmsBySmsDate(date);
        else
            dtoList = mySmsService.getMySmsBySmsDate(date);

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping("/latest-my-sms")
    public ResponseEntity<List<MySmsDto>> getLatestMyMySms() {

        List<MySmsDto> dtoList = null;

        dtoList = mySmsService.getLatestMySmsBySmsDate();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @PostMapping(value = "/upload-my-sms" )
    public String uploadMySms(@RequestBody MySmsDto[] mySmsDtoArr){

        LOGGER.info("uploadMySms is called(" + mySmsDtoArr.length + ")");

        mySmsService.saveMySms(mySmsDtoArr);



        return "";

    }

}
