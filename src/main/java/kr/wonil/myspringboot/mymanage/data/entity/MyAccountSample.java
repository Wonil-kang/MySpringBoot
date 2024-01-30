package kr.wonil.myspringboot.mymanage.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.myinvest.data.entity.pk.DividendRatePK;
import kr.wonil.myspringboot.mymanage.data.dto.MyAccountDto;
import kr.wonil.myspringboot.mymanage.data.entity.pk.MyAccountSamplePK;
import lombok.Data;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "MY_ACC_SAMPLE_VIEW")
@IdClass(MyAccountSamplePK.class)
@Immutable
@Data
public class MyAccountSample {

    @Id
    @Column(name = "SAMPLE_TYPE")
    String sampleType;
    @Id
    @Column(name = "SAMPLE")
    String sample;
}
