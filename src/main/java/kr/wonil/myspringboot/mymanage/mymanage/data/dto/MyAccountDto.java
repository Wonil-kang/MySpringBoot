package kr.wonil.myspringboot.mymanage.mymanage.data.dto;

import kr.wonil.test.myspringboot.mymanage.data.entity.MyAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyAccountDto {

    int accountId;
    String accountInfo;
    String account;
    String password;
    String description;
    String rdtt;
    String mdtt;
    String registerId;
    String modifierId;

    public MyAccountDto(MyAccount entity){
        accountId = entity.getAccountId();
        accountInfo = entity.getAccountInfo();
        account = entity.getAccount();
        password = entity.getPassword();
        description = entity.getDescription();
        rdtt = entity.getRdtt();
        mdtt = entity.getMdtt();
        registerId = entity.getRegisterId();
        modifierId = entity.getModifierId();
    }

}
