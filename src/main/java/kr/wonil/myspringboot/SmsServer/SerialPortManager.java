package kr.wonil.myspringboot.SmsServer;

import com.fazecast.jSerialComm.SerialPort;

public class SerialPortManager {

    /**
     * Quectel / EG915 / USB Modem 계열 포트 자동 탐색
     */
    public static SerialPort findCorrectPort() {

        SerialPort[] ports = SerialPort.getCommPorts();

        for (SerialPort p : ports) {

            String desc = p.getDescriptivePortName();
            String sys  = p.getSystemPortName();

            System.out.println("검색 중 포트: " + sys + " (" + desc + ")");

            // ▼ 아래 조건에서 포트 특징을 매칭하면 됨
            if (desc != null &&
                    (desc.contains("Quectel") ||
                            desc.contains("EG915")   ||
                            desc.contains("Modem")   ||
                            desc.contains("USB Serial"))) {

                System.out.println("모뎀 포트 발견! → " + sys);
                return p;
            }
        }

        // 없으면 null (스프링 초기화 단계에서 에러 처리)
        System.err.println("모뎀 포트를 찾지 못했습니다!");
        return null;
    }

    /**
     * 포트를 실제로 열기 위한 공통 설정
     */
    public static void initPort(SerialPort port) {
        port.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 3000, 3000);
    }
}
