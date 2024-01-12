package kr.wonil.myspringboot.myexpense.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "expense_code_tb")
@Data
public class ExpenseCode {

    @Id
    @Column(name = "CODE_ID")
    private Integer expenseCodeId;
    @Column(name = "EXPENSE_CODE")
    private String expenseCode;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "CODE_NAME")
    private String codeName;
    @Column(name = "RECENT_USED_DATE")
    private String recentUsedDate;
    @Column(name = "USE_YN")
    private String useFlag;
    @Column(name = "RDTT")
    private String rdtt;
    @Column(name = "MDTT")
    private String mdtt;
    @Column(name = "REGR_ID")
    private String regdId;
    @Column(name = "MODR_ID") //@Column(columnDefinition = "TEXT")
    private String modrId;
    @Column(name = "STAT_IN_YN")
    private String statisticFlag;


}
