package kr.wonil.myspringboot.sms.data.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//Modem 추출 객체
@Data
public class SmsDto {

    final long srcSmsId;
    final String phoneNumber;
    final String messageText;
    final LocalDateTime receivedAt;

    public SmsDto(int srcSmsId, String phoneNumber, String messageText, LocalDateTime receivedAt) {
        this.srcSmsId = srcSmsId;
        this.phoneNumber = phoneNumber;
        this.messageText = messageText;
        this.receivedAt = receivedAt;
    }

    public String getReceivedAt() {
        if (receivedAt == null) return null;
        return receivedAt.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public long getReceivedAtLong() {
        if (receivedAt == null) return 0L;

        // 시스템 타임존 기준으로 epoch millisecond 반환
        return receivedAt.atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}
