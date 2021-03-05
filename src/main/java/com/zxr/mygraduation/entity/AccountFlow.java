package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class AccountFlow {
    /**
     *主键ID
     *表字段：id
     */
    private Integer userId;
    /**
     *转出帐户
     *表字段：out_account
     */
    private Integer outAccount;
    /**
     *转入帐户
     *表字段：in_account
     */
    private Integer inAccount ;
    /**
     *金额
     *表字段：money
     */
    private Double money;
    /**
     *创建时间
     *表字段：create_time
     */
    private Timestamp createTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getOutAccount() {
        return outAccount;
    }
    public void setOutAccount(Integer outAccount) {
        this.outAccount = outAccount;
    }
    public Integer getInAccount() {
        return inAccount;
    }
    public void setInAccount(Integer inAccount) {
        this.inAccount = inAccount;
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
        return "AccountFlow{" +
                "userId=" + userId +
                ", outAccount=" + outAccount +
                ", inAccount=" + inAccount +
                ", money=" + money +
                ", createTime=" + createTime +
                '}';
    }
}
