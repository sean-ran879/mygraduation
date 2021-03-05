package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class BankaccountFlow {
    /**
     *银行交易流水号
     *表字段：flow_order
     */
    private Integer flowOrder;
    /**
     *我的帐户
     *表字段：myaccount
     */
    private String myaccount;
    /**
     *用户Id
     *表字段：user_id
     */
    private Integer userId;
    /**
     *金额
     *表字段：money
     */
    private Double money;
    private Timestamp createTime;
    public Integer getFlowOrder() {
        return flowOrder;
    }
    public void setFlowOrder(Integer flowOrder) {
        this.flowOrder = flowOrder;
    }
    public String getMyaccount() {
        return myaccount;
    }
    public void setMyaccount(String myaccount) {
        this.myaccount = myaccount;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    @Override
    public String toString() {
        return "BankaccountFlow{" +
                "flowOrder=" + flowOrder +
                ", myaccount=" + myaccount +
                ", userId='" + userId + '\'' +
                ", money=" + money +
                ", createTime=" + createTime +
                '}';
    }
}
