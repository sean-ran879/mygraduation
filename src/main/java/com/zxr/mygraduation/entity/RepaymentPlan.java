package com.zxr.mygraduation.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class RepaymentPlan {
    /**
     * 还款单号
     * 表字段:repay_num
     */
    private Integer repayNum;
    /**
     * 交易单号
     * 表字段:transflow_id
     */
    private Integer transflowId;
    /**
     * 投资人id
     * 表字段:invest_id
     */
    private  Integer investId;
    /**
     * 借款人id
     * 表字段:loan_id
     */
    private  Integer loanId;
    /**
     * 还款期数
     * 表字段:per_period
     */
    private  Integer perPeriod;
    /**
     * 还款时间
     * 表字段:borrow_date
     */
    private LocalDate borrowDate;
    /**
     * 还款金额
     * 表字段:rep_money
     */
    private  Double repMoney;
    /**
     * 还款状态
     * 表字段:repay_status
     */
    private Integer repayStatus;
    /**
     * 实际还款时间
     * 表字段:real_repaydate
     */
    private Timestamp realRepaydate;
    public Integer getRepayNum() {
        return repayNum;
    }
    public void setRepayNum(Integer repayNum) {
        this.repayNum = repayNum;
    }
    public Integer getTransflowId() {
        return transflowId;
    }
    public void setTransflowId(Integer transflowId) {
        this.transflowId = transflowId;
    }
    public Integer getInvestId() {
        return investId;
    }
    public void setInvestId(Integer investId) {
        this.investId = investId;
    }
    public Integer getLoanId() {
        return loanId;
    }
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
    public Integer getPerPeriod() {
        return perPeriod;
    }
    public void setPerPeriod(Integer perPeriod) {
        this.perPeriod = perPeriod;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate  borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Double getRepMoney() {
        return repMoney;
    }
    public void setRepMoney(Double repMoney) {
        this.repMoney = repMoney;
    }
    public Integer getRepayStatus() {
        return repayStatus;
    }
    public void setRepayStatus(Integer repayStatus) {
        this.repayStatus = repayStatus;
    }
    public Timestamp getRealRepaydate() {
        return realRepaydate;
    }
    public void setRealRepaydate(Timestamp realRepaydate) {
        this.realRepaydate = realRepaydate;
    }
    @Override
    public String toString() {
        return "RepaymentPlan{" +
                "repayNum=" + repayNum +
                ", transflowId=" + transflowId +
                ", investId=" + investId +
                ", loanId=" + loanId +
                ", perPeriod=" + perPeriod +
                ", borrowDate=" + borrowDate +
                ", repMoney=" + repMoney +
                ", repayStatus=" + repayStatus +
                ", realRepaydate=" + realRepaydate +
                '}';
    }
}
