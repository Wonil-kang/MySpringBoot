package kr.wonil.myspringboot.mymanage.mymanage.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyAccountPK implements Serializable {

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Column(name = "ACCOUNT_INFO")
    private String accountInfo;
    @Column(name = "ACCOUNT")
    private String account;

}
