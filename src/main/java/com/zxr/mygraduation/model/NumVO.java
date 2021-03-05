package com.zxr.mygraduation.model;
/**
 * NumVO class
 * @author xueran.zhang
 * @date 2020/04/17
 */
public class NumVO {
    private Integer loanNum;
    private Integer investNum;
    private Integer OrderNum;

    public Integer getLoanNum() {
        return loanNum;
    }

    public void setLoanNum(Integer loanNum) {
        this.loanNum = loanNum;
    }

    public Integer getInvestNum() {
        return investNum;
    }

    public void setInvestNum(Integer investNum) {
        this.investNum = investNum;
    }

    public Integer getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(Integer orderNum) {
        OrderNum = orderNum;
    }

    @Override
    public String toString() {
        return "NumVO{" +
                "loanNum=" + loanNum +
                ", investNum=" + investNum +
                ", OrderNum=" + OrderNum +
                '}';
    }
}
