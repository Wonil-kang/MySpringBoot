package kr.wonil.myspringboot.mymanage.data.dto;

import kr.wonil.myspringboot.mymanage.data.entity.MyAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyAccountDto {

    String accountType;
    String accountInfo;
    String account;
    String password;
    String description;
    String rdtt;
    String mdtt;
    String registerId;
    String modifierId;

    public MyAccountDto(MyAccount entity){
        accountType = entity.getAccountType();
        accountInfo = entity.getAccountInfo();
        account = entity.getAccount();
        password = entity.getPassword();
        description = entity.getDescription();
        rdtt = entity.getRdtt();
        mdtt = entity.getMdtt();
        registerId = entity.getRegisterId();
        modifierId = entity.getModifierId();
    }

    public String getAccountInfo(){
        if(accountInfo == null)
            return "-";
        return accountInfo;
    }

    public String getAccount(){

        if(account == null)
            return "-";
        return account;
    }

    public String getDescription(){

        if(description == null)
            return "-";
        return description;
    }

}
