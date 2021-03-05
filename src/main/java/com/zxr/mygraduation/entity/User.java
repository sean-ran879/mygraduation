package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * 表:user
 *用户表
 * @author xueran.zhang
 * @date 2020-03-19
 */
public class User {
    /**
     * 主键ID
     * 表字段:user_id
     */
    private Integer userId;
    /**
     * 用户电话
     * 表字段:user_phone
     */
    private String userPhone;
    /**
     * 登录密码
     * 表字段:password
     */
    private String passWord;
    /**
     * 用户角色
     * 表字段:user_role
     */
    private String userRole;
    /**
     * 交易密码
     * 表字段:trans_pw
     */
    private String transPw;
    private Timestamp createTime;
    private Timestamp updateTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public String getTransPw() {
        return transPw;
    }
    public void setTransPw(String transPw) {
        this.transPw = transPw;
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
        return "User{" +
                "userId=" + userId +
                ", userPhone='" + userPhone + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userRole='" + userRole + '\'' +
                ", transPw='" + transPw + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
