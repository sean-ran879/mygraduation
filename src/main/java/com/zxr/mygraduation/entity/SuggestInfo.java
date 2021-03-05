package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class SuggestInfo {
    /**
     *主键id
     *表字段：id
     */
    private Integer status;
    private Integer id;
    /**
     *用户id
     *表字段：user_id
     */
    private Integer userId;
    /**
     *联系方式
     *表字段：phone
     */
    private String phone;
    /**
     *内容
     *表字段：suggest
     */
    private String suggest;
    private Timestamp createTime;
    private  Timestamp updateTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSuggest() {
        return suggest;
    }
    public void setSuggest(String suggest) {
        this.suggest = suggest;
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
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SuggestInfo{" +
                "status=" + status +
                ", id=" + id +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", suggest='" + suggest + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
