package com.zxr.mygraduation.entity;

import java.sql.Timestamp;
/**
 * @author keriezhang
 * @date 2016/10/31
 */
public class UserCode {
    private String userPhone;
    private String userCode;
    private Timestamp createTime;
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserCode() {
        return userCode;
    }
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
