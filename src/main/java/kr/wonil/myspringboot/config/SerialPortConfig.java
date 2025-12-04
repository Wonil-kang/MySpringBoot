package kr.wonil.myspringboot.config;

import com.fazecast.jSerialComm.SerialPort;
import kr.wonil.myspringboot.SmsServer.SerialPortManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerialPortConfig {

    @Bean
    public SerialPort serialPort() {
        SerialPort port = SerialPortManager.findCorrectPort();

        if (port == null) return null;

        port.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.openPort();

        return port;
    }
}