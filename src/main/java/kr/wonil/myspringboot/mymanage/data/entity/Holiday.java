package kr.wonil.myspringboot.mymanage.data.entity;

import jakarta.persistence.*;
import kr.wonil.myspringboot.mymanage.data.dto.HolidayDto;
import lombok.Data;


@Entity
@Table(name = "holiday")
@Data
public class Holiday {

    @Id
    @Column(name = "DATE")
    private String date;

    public Holiday(HolidayDto dto){
        date = dto.getDate();
    }

    public Holiday() {
        
    }
}
