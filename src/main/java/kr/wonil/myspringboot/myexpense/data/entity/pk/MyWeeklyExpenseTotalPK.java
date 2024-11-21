package kr.wonil.myspringboot.myexpense.data.entity.pk;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyWeeklyExpenseTotalPK implements Serializable {

    @Column(name = "year")
    private String year;
    @Column(name = "week_number")
    private Integer weekNumber;

}
