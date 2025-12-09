package kr.wonil.myspringboot.scheduler;

import kr.wonil.myspringboot.SmsServer.ModemService;
import kr.wonil.myspringboot.sms.data.dto.MySmsDto;
import kr.wonil.myspringboot.sms.data.dto.SmsDto;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import kr.wonil.myspringboot.sms.service.MySmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
//@Component
public class SmsScheduler {

    private final ModemService modemService;
    private final MySmsService mySmsService;

    // 메시지 삭제 여부 옵션(원하는 대로 true/false 바꾸기)
    private final boolean deleteAfterSave = false;

    public SmsScheduler(ModemService modemService, MySmsService mySmsService) {
        this.modemService = modemService;
        this.mySmsService = mySmsService;
    }

    /**
     * 10초마다 모뎀에서 미읽은 문자 조회 → DB 저장 → 필요 시 모뎀에서 삭제
     */
    //@Scheduled(fixedDelay = 10_000) // = 10초
    public void pollSms() {

        try {
            List<SmsDto> messages = modemService.readUnread();

            if (messages.isEmpty()) {
                // System.out.println("[Scheduler] 새 문자 없음");
                return;
            }

            log.info("[Scheduler] 수신 문자 개수: {}", messages.size());

            for (SmsDto sms : messages) {

                // 1) DB 저장
                if(mySmsService.saveMySms(new MySms(sms)) != null) {

                    // 2) 모뎀에서 삭제할지 여부
                    if (deleteAfterSave) {
                        modemService.deleteByIndex(sms.getSrcSmsId());
                        log.info("[Scheduler] 문자 삭제 완료: index={}", sms.getSrcSmsId());
                    }
                }
            }

        } catch (Exception e) {
            log.error("[Scheduler] 문자 조회 중 오류 발생: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}