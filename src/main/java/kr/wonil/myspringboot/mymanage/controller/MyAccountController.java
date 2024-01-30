package kr.wonil.myspringboot.mymanage.controller;

import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountSampleDto;
import kr.wonil.myspringboot.mymanage.service.MyAccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class MyAccountController {

    private Logger LOGGER = LoggerFactory.getLogger(MyAccountController.class);
    private final MyAccountService myAccountService;


    @GetMapping(value = "/my-account/all")
    public ResponseEntity<List<MyAccountDto>> getMyAllAccount(){

        List<MyAccountDto> dtoList = myAccountService.getAllMyAccount();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }

    @GetMapping(value = "/my-account/sample")
    public ResponseEntity<List<MyAccountSampleDto>> getMyAccountSample(){

        List<MyAccountSampleDto> dtoList = myAccountService.getMyAccountSample();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }


    @GetMapping(value = "/my-account/id")
    public ResponseEntity<MyAccountDto> getMyAccountById(@RequestParam int accountId){

        MyAccountDto dto = myAccountService.getMyAccountById(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping(value = "/upload-my-account" )
    public String uploadMyAccount(@RequestBody MyAccountDto[] dtoArr){

        LOGGER.info("uploadMyAccount is called(" + dtoArr.length + ")");
        myAccountService.saveMyAccount(dtoArr);

        return "";
    }

    @PostMapping(value = "/delete-my-account" )
    public String deleteMyAccount(@RequestBody MyAccountDto[] dtoArr){

        LOGGER.info("deleteMyAccount is called(" + dtoArr.length + ")");
        myAccountService.deleteMyAccount(dtoArr);

        return "";
    }

}
