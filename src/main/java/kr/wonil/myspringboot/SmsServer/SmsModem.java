package kr.wonil.myspringboot.SmsServer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.OutputStream;
import com.fazecast.jSerialComm.SerialPort;
import kr.wonil.myspringboot.sms.data.entity.MySms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsModem {

    private SerialPort port;
    private InputStream in;
    private OutputStream out;


    // 응답 파싱용 포맷 (예: 24/11/14,13:10:30+36)
    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yy/MM/dd,HH:mm:ss");

    /**
     * Quectel / EG915가 포함된 포트를 자동 탐색.
     */
    private static SerialPort findEg915PortOrThrow() {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("사용 가능한 포트 목록:");
        for (SerialPort p : ports) {
            System.out.println(" - " + p.getSystemPortName()
                    + " (" + p.getDescriptivePortName() + ")");
        }

        for (SerialPort p : ports) {
            String desc = p.getDescriptivePortName();
            if (desc != null &&
                    (desc.contains("Quectel") || desc.contains("EG915"))) {
                System.out.println("EG915 포트 자동 선택: " + p.getSystemPortName());
                return p;
            }
        }
        throw new IllegalStateException("Quectel / EG915 관련 포트를 찾지 못했습니다.");
    }

    private void initModem() throws Exception {
        System.out.println("=== 모뎀 초기화 시작 ===");

        // 기본 통신 체크
        sendAt("AT");          // OK 나와야 정상

        sendAt("ATE0");        // 에코 끄기

        // 문자모드 설정
        sendAt("AT+CMGF=1");   // Text mode

        sendAt("AT+CSCS=\"GSM\""); // 문자셋 (한글은 추후 UCS2 사용 가능)

        // 문자 저장소 확인
        // "ME" (모듈 내부 메모리) / "SM" (SIM 카드)에 따라 다름
        sendAt("AT+CPMS?");

        // 필요하면 저장소를 강제로 설정
        // sendAt("AT+CPMS=\"ME\",\"ME\",\"ME\"");

        // 네트워크 등록 상태 체크 (선택)
        sendAt("AT+CREG?");    // CS 등록

        sendAt("AT+CEREG?");   // LTE 등록

        // 문자 수신 알림 끄기 (폴링 방식이면 굳이 알림 불필요)
        sendAt("AT+CNMI=0,0,0,0,0");

        System.out.println("=== 모뎀 초기화 완료 ===");

}


    private synchronized String sendAt(String cmd) throws Exception {
        String fullCmd = cmd + "\r";
        out.write(fullCmd.getBytes(StandardCharsets.US_ASCII));
        out.flush();

        StringBuilder sb = new StringBuilder();
        byte[] buf = new byte[1024];

        long start = System.currentTimeMillis();
        while (true) {
            if (in.available() > 0) {
                int len = in.read(buf);
                if (len > 0) {
                    sb.append(new String(buf, 0, len, StandardCharsets.US_ASCII));
                    String tmp = sb.toString();
                    if (tmp.contains("\r\nOK\r\n") || tmp.contains("\r\nERROR\r\n")) {
                        break;
                    }
                }
            }
            if (System.currentTimeMillis() - start > 3000) {
                break;
            }
            Thread.sleep(50);
        }

        String resp = sb.toString();
        System.out.println(">> " + cmd);
        System.out.println("<< " + resp);
        return resp;
    }



    /**
     * 미읽은 문자(REC UNREAD)를 조회해서 리스트로 반환.
     */
    public List<MySms> readUnreadMessages() throws Exception {
        String response = sendAt("AT+CMGL=\"REC UNREAD\"");

        List<MySms> messages = new ArrayList<>();
        String[] lines = response.split("\r\n");

        // +CMGL: 1,"REC UNREAD","+821012345678","","24/11/14,13:10:30+36"
        Pattern headerPattern = Pattern.compile(
                "^\\+CMGL: (\\d+),\"[^\"]*\",\"([^\"]*)\",\"\",\"([0-9/,:+]+)\".*$"
        );

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            Matcher m = headerPattern.matcher(line);
            if (m.matches()) {
                int index = Integer.parseInt(m.group(1)); // SRC_SMS_ID
                String phone = m.group(2);
                String dateStr = m.group(3);             // 예: 24/11/14,13:10:30+36

                String dtPart = dateStr.split("\\+")[0];
                LocalDateTime receivedTime = LocalDateTime.parse(dtPart, TIME_FORMATTER);

                String body = "";
                if (i + 1 < lines.length) {
                    body = lines[i + 1]; // 바로 다음 줄을 본문으로 가정 (단순 버전)
                }

                messages.add(new MySms(index, phone, body, receivedTime));
            }
        }

        return messages;
    }

    /**
     * 특정 인덱스의 SMS를 모뎀 저장소에서 삭제.
     */
    public void deleteSmsByIndex(int index) throws Exception {
        String cmd = "AT+CMGD=" + index;
        String resp = sendAt(cmd);
        System.out.println("삭제 결과(" + index + "): " + resp.replace("\r\n", "\\r\\n"));
    }

    public void close() throws IOException {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
        } catch (Exception e) {
            // 무시
        }
        if (port != null && port.isOpen()) {
            port.closePort();
        }
    }

}
