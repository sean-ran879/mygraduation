package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/03/23
 */
public class TradingOrder {
    /**
     *交易单号
     *表字段：transflow_id
     */
    private Integer transflowId;
    /**
     *借款用户id
     *表字段：loan_id
     */
    private Integer loanId;
    /**
     *投资id
     *表字段：invest_id
     */
    private Integer investId ;
    /**
     *借款金额
     *表字段：all_money
     */
    private Double allMoney;
    /**
     *借款期数
     *表字段：total_period
     */
    private Integer totalPeriod;
    /**
     *借款用途
     *表字段：use_loan
     */
    private String useLoan;
    /**
     *手续费率
     *表字段：rate
     */
    private Double rate;
    /**
     *信用值
     *表字段：credit_value
     */
    private Integer creditValue;
    /**
     *订单状态
     *表字段：order_status
     */
    private Integer orderStatus;
    /**
     *交易时间
     *表字段：trans_time
     */
    private Timestamp transTime;
    public Integer getTransflowId() {
        return transflowId;
    }
    public void setTransflowId(Integer transflowId) {
        this.transflowId = transflowId;
    }
    public Integer getLoanId() {
        return loanId;
    }
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
    public Integer getInvestId() {
        return investId;
    }
    public void setInvestId(Integer investId) {
        this.investId = investId;
    }
    public Double getAllMoney() {
        return allMoney;
    }
    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }
    public Integer getTotalPeriod() {
        return totalPeriod;
    }
    public void setTotalPeriod(Integer totalPeriod) {
        this.totalPeriod = totalPeriod;
    }
    public String getUseLoan() {
        return useLoan;
    }
    public void setUseLoan(String useLoan) {
        this.useLoan = useLoan;
    }
    public Double getRate() {
        return rate;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }
    public Integer getCreditValue() {
        return creditValue;
    }
    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }
    public Integer getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Timestamp getTransTime() {
        return transTime;
    }
    public void setTransTime(Timestamp transTime) {
        this.transTime = transTime;
    }
    @Override
    public String toString() {
        return "TradingOrder{" +
                "transflowId=" + transflowId +
                ", loanId=" + loanId +
                ", investId=" + investId +
                ", allMoney=" + allMoney +
                ", totalPeriod=" + totalPeriod +
                ", useLoan='" + useLoan + '\'' +
                ", rate=" + rate +
                ", creditValue=" + creditValue +
                ", orderStatus=" + orderStatus +
                ", transTime=" + transTime +
                '}';
    }
}
