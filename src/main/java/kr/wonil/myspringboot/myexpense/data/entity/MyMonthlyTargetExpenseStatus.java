package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Table(name = "MY_MONTHLY_TARGET_EXPENSE_STATUS_VIEW")
@Data
@Subselect("select * from MY_MONTHLY_TARGET_EXPENSE_STATUS_VIEW")
public class MyMonthlyTargetExpenseStatus {

    @Id
    @Column(name = "month")
    private String month;
    @Column(name = "NUMBER_OF_DAYS")
    private Integer numberOfDays;
    @Column(name = "UDR_HALF_TARGET")
    private Integer underHalfTargetNumber;
    @Column(name = "UDR_TARGET")
    private Integer underTargetNumber;
    @Column(name = "UPP_TARGET")
    private Integer upperTargetNumber;
    @Column(name = "UPP_DOUBLE_TARGET")
    private Integer upperDoubleTargetNumber;
    @Column(name = "UDR_HALF_TARGET_RATE")
    private Double underHalfTargetRate;
    @Column(name = "UDR_TARGET_RATE")
    private Double underTargetRate;
    @Column(name = "UPP_TARGET_RATE")
    private Double upperTargetRate;
    @Column(name = "UPP_DOUBLE_TARGET_RATE")
    private Double upperDoubleTargetRate;

}
