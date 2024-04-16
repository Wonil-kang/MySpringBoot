package kr.wonil.myspringboot.myinvest.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "snp_yoy_view")
@Data
@Subselect("select * from snp_yoy_view")
public class SnPYoY {


    @Column(name = "ticker_name")
    private String tickerName;
    @Id
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "last_date")
    private String lastDate;
    @Column(name = "last_close")
    private double lastClose;
    @Column(name = "date")
    private String date;
    @Column(name = "close")
    private double close;
    @Column(name = "diff")
    private double difference;
    @Column(name = "diff_ratio")
    private double differenceRatio;

}
