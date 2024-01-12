package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Data
@Table(name = "my_total_base_point_view")
@Subselect("select * from my_total_base_point_view")
public class BasePoint {

    //type, last_date, one_week_date, one_month_date, three_month_date, half_year_date, one_year_date
    @Id
    @Column(name = "type")
    private String type;
    @Column(name = "last_date")
    private int oneDayAgo;
    @Column(name = "one_week_date")
    private int oneWeekAgo;
    @Column(name = "one_month_date")
    private int oneMonthAgo;
    @Column(name = "three_month_date")
    private int threeMonthAgo;
    @Column(name = "half_year_date")
    private int halfYearAgo;
    @Column(name = "one_year_date")
    private int oneYearAgo;

}
