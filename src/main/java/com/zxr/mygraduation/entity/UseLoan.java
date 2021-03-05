package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class UseLoan {
    /**
     *主键ID
     *表字段：id
     */
    private Integer id;
    /**
     *借款用途
     *表字段：user_loan
     */
    private String useLoan;
    private Timestamp createTime;
    private Timestamp updateTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUseLoan() {
        return useLoan;
    }
    public void setUseLoan(String useLoan) {
        this.useLoan = useLoan;
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
        return "Useloan{" +
                "id=" + id +
                ", useLoan='" + useLoan + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
