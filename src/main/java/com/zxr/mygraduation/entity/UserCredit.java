package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class UserCredit {
    /**
     * 用户id
     * 表字段:user_id
     */
    private  Integer userId;
    /**
     * 信用值
     * 表字段:credit_value
     */
    private Integer creditValue;
    /**
     * 授信额度
     * 表字段:all_limit
     */
    private  Double allLimit;
    /**
     * 当前额度
     * 表字段:pre_limit
     */
    private  Double preLimit;
    /**
     * 创建时间
     * 表字段:create_time
     */
    private Timestamp createTime;
    /**
     * 更新时间
     * 表字段:update_time
     */
    private  Timestamp updateTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getCreditValue() {
        return creditValue;
    }
    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }
    public Double getAllLimit() {
        return allLimit;
    }
    public void setAllLimit(Double allLimit) {
        this.allLimit = allLimit;
    }
    public Double getPreLimit() {
        return preLimit;
    }
    public void setPreLimit(Double preLimit) {
        this.preLimit = preLimit;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Timestamp getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    @Override
    public String toString() {
        return "UserCredit{" +
                "userId=" + userId +
                ", creditValue=" + creditValue +
                ", allLimit=" + allLimit +
                ", preLimit=" + preLimit +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
