package com.zxr.mygraduation.model;
import java.time.LocalDate;
/**
 * 传递给前端的json：还款总额，手续费总额，单期手续费，单期还款费，平台服务费
 * @author xueran.zhang
 * @date 2020/03/25
 */
public class RepaymentPlanVO {
    /**
     * 交易单号，投资人Id，借款人Id，还款期数
     * 还款时间，还款金额，还款状态
     */
    private  Integer transflowId;
    private Integer investId;
    private Integer loanId;
    private Integer perPeriod;
    private LocalDate borrowDate;
    private  Double repMoney;
    private  Integer repayStatus;
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
    public void setBorrowDate(LocalDate borrowDate) {
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
    @Override
    public String toString() {
        return "RepaymentPlanVO{" +
                "tranflowId=" + transflowId +
                ", investId=" + investId +
                ", loanId=" + loanId +
                ", perPeriod=" + perPeriod +
                ", borrowDate=" + borrowDate +
                ", repMoney=" + repMoney +
                ", repayStatus=" + repayStatus +
                '}';
    }
}
