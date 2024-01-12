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
@Table(name = "fx_avg_stat_view")
@Data
@Subselect("select * from fx_avg_stat_view")
public class FxStatus {

    @Id
    @Column(name = "ticker_name")
    private String transactionId;
    @Column(name = "ticker")
    private String smsBody;
    @Column(name = "today")
    private Double todayValue;
    @Column(name = "avg_1m")
    private Double average1Month;
    @Column(name = "avg_3m")
    private Double average3Month;
    @Column(name = "avg_6m")
    private Double average6Month;
    @Column(name = "avg_1y")
    private Double average1Year;
    @Column(name = "avg_3y")
    private Double average3Year;
    @Column(name = "avg_5y")
    private Double average5Year;
    @Column(name = "avg_10y")
    private Double average10Year;

}
