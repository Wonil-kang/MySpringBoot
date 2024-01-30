package kr.wonil.myspringboot.mymanage.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.myspringboot.mymanage.data.entity.MyAccountSample;
import lombok.Data;
import org.hibernate.annotations.Immutable;


@Data
public class MyAccountSampleDto {

    private String sampleType;
    private String sample;

    public MyAccountSampleDto(MyAccountSample entity){

        this.sampleType = entity.getSampleType();;
        this.sample = entity.getSample();
    }
}
