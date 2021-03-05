package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class CreditVerify {
    private Integer id;
    private Integer userId;
    /**
     * 审核结果
     * 表字段:result
     */
    private  Integer result;
    /**
     * 审核类型
     * 表字段:verify_type
     */
    private  Integer verifyType;
    private Timestamp createTime;
    private  Timestamp updateTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public Integer getVerifyType() {
        return verifyType;
    }
    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreditVerify{" +
                "id=" + id +
                ", userId=" + userId +
                ", result=" + result +
                ", verifyType=" + verifyType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
