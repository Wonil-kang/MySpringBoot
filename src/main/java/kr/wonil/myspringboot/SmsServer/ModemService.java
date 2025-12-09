package kr.wonil.myspringboot.SmsServer;

import com.fazecast.jSerialComm.SerialPort;
import jakarta.annotation.PostConstruct;
import kr.wonil.myspringboot.sms.data.dto.SmsDto;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

//@Service
public class ModemService {

    private final SerialPort port;
    private final ModemManager modemManager;

    private OutputStream out;
    private InputStream in;

    public ModemService(SerialPort port, ModemManager modemManager) {
        this.port = port;
        this.modemManager = modemManager;
    }

    //@PostConstruct
    public void init() throws Exception {
        this.out = port.getOutputStream();
        this.in  = port.getInputStream();

        //     우리가 방금 만든 modemManager.initModem(...) 을 호출해야 함
        modemManager.initModem(port, out, in);
        System.out.println("ModemService 초기화 완료");
    }

    public List<SmsDto> readUnread() throws Exception {
        return modemManager.readUnreadMessages(out, in);
    }

    public void deleteByIndex(Integer index) throws Exception {
        modemManager.deleteSmsByIndex(out, in, index);
    }
}