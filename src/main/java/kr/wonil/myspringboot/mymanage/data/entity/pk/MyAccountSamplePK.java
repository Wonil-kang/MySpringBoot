package kr.wonil.myspringboot.mymanage.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyAccountSamplePK implements Serializable {

    @Column(name = "SAMPLE_TYPE")
    String sampleType;
    @Column(name = "SAMPLE")
    String sample;

}
