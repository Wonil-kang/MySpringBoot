package kr.wonil.myspringboot.mymanage.controller;

import kr.wonil.myspringboot.mymanage.data.dto.MyMemoDto;
import kr.wonil.myspringboot.mymanage.service.MyMemoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MyMemoController {

    private Logger LOGGER = LoggerFactory.getLogger(MyMemoController.class);
    private final MyMemoService myMemoService;


    @GetMapping(value = "/my-memo/all")
    public ResponseEntity<List<MyMemoDto>> getAllMyMemo(){

        List<MyMemoDto> dtoList = myMemoService.getAllMyMemo();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);

    }


    @GetMapping(value = "/my-memo/id")
    public ResponseEntity<MyMemoDto> getMyMemoById(@RequestParam int memoId){

        MyMemoDto dto = myMemoService.getMyMemoById(memoId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(value = "/my-memo/random")
    public ResponseEntity<MyMemoDto> getRandomMyMemo(){

        MyMemoDto dto = myMemoService.getRandomMyMemo();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping(value = "/upload-my-memo" )
    public String uploadMyMemo(@RequestBody MyMemoDto[] dtoArr){

        LOGGER.info("uploadMyMemo is called(" + dtoArr.length + ")");
        myMemoService.saveMyMemo(dtoArr);

        return "";
    }



}
