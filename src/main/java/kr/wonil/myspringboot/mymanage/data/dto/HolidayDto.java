package kr.wonil.myspringboot.mymanage.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.wonil.myspringboot.mymanage.data.entity.Holiday;
import lombok.Data;


@Data
public class HolidayDto {

    private String date;

    public HolidayDto(Holiday holiday) {
        if(holiday != null) {
            this.date = holiday.getDate();
        }
    }

}
