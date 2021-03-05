package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class BankBind {
    /**
     *用户ID
     *表字段：user_id
     */
    private Integer userId;
    /**
     *银行卡名称
     *表字段：bank_name
     */
    private String bankName;
    /**
     *银行卡号
     *表字段：bank_id
     */
    private String bankId;
    /**
     *绑定时间
     *表字段：create_time
     */
    private Timestamp createTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankId() {
        return bankId;
    }
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
