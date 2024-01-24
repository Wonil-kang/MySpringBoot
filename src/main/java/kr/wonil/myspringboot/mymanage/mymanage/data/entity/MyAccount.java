package kr.wonil.myspringboot.mymanage.mymanage.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.test.myspringboot.mymanage.data.dto.MyAccountDto;
import lombok.Data;


@Entity
@Table(name = "MY_ACC_MNG_TB")
@Data
public class MyAccount {

    @Id
    @Column(name = "ACCOUNT_ID")
    int accountId;
    @Column(name = "ACCOUNT_INFO")
    String accountInfo;
    @Column(name = "ACCOUNT")
    String account;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "RDTT")
    String rdtt;
    @Column(name = "MDTT")
    String mdtt;
    @Column(name = "REGR_ID")
    String registerId;
    @Column(name = "MODR_ID")
    String modifierId;

    public MyAccount(MyAccountDto dto){

        accountId = dto.getAccountId();
        accountInfo = dto.getAccountInfo();
        account = dto.getAccount();
        password = dto.getPassword();
        description = dto.getDescription();
        rdtt = dto.getRdtt();
        mdtt = dto.getMdtt();
        registerId = dto.getRegisterId();
        modifierId = dto.getModifierId();

    }

    public MyAccount() {

    }
}
