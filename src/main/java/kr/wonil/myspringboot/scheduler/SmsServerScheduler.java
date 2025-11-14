package kr.wonil.myspringboot.scheduler;

import jakarta.annotation.PostConstruct;
import kr.wonil.myspringboot.SmsServer.SmsModem;
import kr.wonil.myspringboot.sms.data.entity.MySms;
import kr.wonil.myspringboot.sms.service.MySmsService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.io.IOException;

@Service
@EnableScheduling
public class SmsServerScheduler {

    private SmsModem smsModem;
    private final ReentrantLock lock = new ReentrantLock();
    private final MySmsService mySmsService;

    public SmsServerScheduler(MySmsService mySmsService) {
        this.mySmsService = mySmsService;
    }


    @PostConstruct
    public void init() throws Exception {
        // 포트 자동 탐색 + 모뎀 초기화까지 한 번에
        this.smsModem = new SmsModem();
    }

    @Scheduled(fixedDelay = 10_000)
    public void pollSms() {

        if (!lock.tryLock()) {
            System.out.println("이전 작업이 아직 끝나지 않아 이번 폴링은 건너뜁니다.");
            return;
        }

        try {
            List<MySms> list = smsModem.readUnreadMessages();
            for (MySms msg : list) {

                // insert 내용 추가
                mySmsService.insertSmsDataToDB(msg);

                // 내용 삭제
                //smsModem.deleteSmsByIndex(msg.getSourceSmsId());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @PreDestroy
    public void shutdown() throws IOException {
        if (smsModem != null) {
            smsModem.close();
        }
    }

}
