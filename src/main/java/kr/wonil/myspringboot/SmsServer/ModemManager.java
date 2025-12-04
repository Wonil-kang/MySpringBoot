package kr.wonil.myspringboot.SmsServer;

import com.fazecast.jSerialComm.SerialPort;
import kr.wonil.myspringboot.sms.data.dto.SmsDto;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ModemManager {

    /**
     * 모뎀 초기 설정 (AT 기본 모드, 문자셋, 텍스트 모드 등)
     */
    public void initModem(SerialPort port, OutputStream out, InputStream in) throws Exception {

        System.out.println("=== 모뎀 초기화 시작 ===");

        sendAt(out, in, "AT");            // 기본 통신 체크
        sendAt(out, in, "ATE0");          // echo off
        sendAt(out, in, "AT+CMGF=1");     // 텍스트 모드
        sendAt(out, in, "AT+CSCS=\"GSM\""); // 문자셋 설정
        sendAt(out, in, "AT+CPMS?");      // 저장소 상태 확인

        System.out.println("=== 모뎀 초기화 완료 ===");
    }


    /**
     * AT 명령 전송 후 응답 수신
     */
    private String sendAt(OutputStream out, InputStream in, String cmd) throws Exception {
        String fullCmd = cmd + "\r";

        System.out.println(">> " + cmd);

        out.write(fullCmd.getBytes(StandardCharsets.US_ASCII));
        out.flush();

        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[2048];

        long start = System.currentTimeMillis();

        while (true) {

            if (in.available() > 0) {
                int len = in.read(buffer);
                if (len > 0) {
                    sb.append(new String(buffer, 0, len, StandardCharsets.US_ASCII));
                    String resp = sb.toString();

                    // OK 또는 ERROR 나오면 종료
                    if (resp.contains("\r\nOK\r\n") || resp.contains("\r\nERROR\r\n")) {
                        break;
                    }
                }
            }

            if (System.currentTimeMillis() - start > 5000) {
                // 5초 대기 후 타임아웃
                break;
            }

            Thread.sleep(50);
        }

        String response = sb.toString();
        System.out.println("<< " + response.replace("\r\n", "\\r\\n"));

        return response;
    }


    /**
     * 특정 SMS 삭제
     */
    public void deleteSmsByIndex(OutputStream out, InputStream in, Long index) throws Exception {
        String resp = sendAt(out, in, "AT+CMGD=" + index);
        System.out.println("SMS 삭제 결과: index " + index + " → " + resp);
    }


    /**
     * 미읽은 문자 전체 조회
     */
    public List<SmsDto> readUnreadMessages(OutputStream out, InputStream in) throws Exception {

        System.out.println("=== 미읽은 문자 조회 ===");

        String response = sendAt(out, in, "AT+CMGL=\"REC UNREAD\"");

        List<SmsDto> result = new ArrayList<>();
        String[] lines = response.split("\r\n");

        /*
            예시 응답:
            +CMGL: 1,"REC UNREAD","+821012345678","","24/11/14,13:10:30+36"
            인증번호 1234입니다

            +CMGL: 2,"REC UNREAD","+821055566677","","24/11/14,13:12:01+36"
            테스트 메시지
         */

        Pattern headerPattern = Pattern.compile(
                "^\\+CMGL: (\\d+),\"[^\"]*\",\"([^\"]*)\",\"\",\"([0-9/,:+]+)\".*$"
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd,HH:mm:ss");

        for (int i = 0; i < lines.length; i++) {

            String line = lines[i].trim();
            Matcher matcher = headerPattern.matcher(line);

            if (matcher.matches()) {

                int smsIndex = Integer.parseInt(matcher.group(1));
                String phoneNumber = matcher.group(2);
                String dateStr = matcher.group(3); // 예: 24/11/14,13:10:30+36

                // "+36" 시간대 제거
                String dateWithoutZone = dateStr.split("\\+")[0];
                LocalDateTime receivedAt = LocalDateTime.parse(dateWithoutZone, formatter);

                String body = "";
                if (i + 1 < lines.length) {
                    body = lines[i + 1].trim();
                }

                SmsDto dto = new SmsDto(
                        smsIndex,
                        phoneNumber,
                        body,
                        receivedAt
                );

                result.add(dto);
            }
        }

        System.out.println("총 " + result.size() + "개의 미읽은 문자 발견");

        return result;
    }

}