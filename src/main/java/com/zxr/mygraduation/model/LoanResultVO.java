package com.zxr.mygraduation.model;
/**
 * 传递给前端的json：还款总额，手续费总额，单期还款费，平台服务费
 * @author xueran.zhang
 * @date 2020/03/25
 */
public class LoanResultVO {
    private Double repayMoney;
    private Double totalCharge;
    private Double singleRepay;
    private Double platformServiceFee;
    public Double getRepayMoney() {
        return repayMoney;
    }
    public void setRepayMoney(Double repayMoney) {
        this.repayMoney = repayMoney;
    }
    public Double getTotalCharge() {
        return totalCharge;
    }
    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Double getSingleRepay() {
        return singleRepay;
    }
    public void setSingleRepay(Double singleRepay) {
        this.singleRepay = singleRepay;
}
    public Double getPlatformServiceFee() {
        return platformServiceFee;
    }
    public void setPlatformServiceFee(Double platformServiceFee) {
        this.platformServiceFee = platformServiceFee;
    }
    @Override
    public String toString() {
        return "LoanResultVO{" +
                "repayMoney=" + repayMoney +
                ", totalCharge=" + totalCharge +
                ", singleRepay=" + singleRepay +
                ", platformServiceFee=" + platformServiceFee +
                '}';
    }
}