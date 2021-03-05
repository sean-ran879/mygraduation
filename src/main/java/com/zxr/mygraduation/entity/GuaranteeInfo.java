package com.zxr.mygraduation.entity;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class GuaranteeInfo {
    /**
     * 担保人id
     * 表字段:guarantee_id
     */
    private  Integer guaranteeId;
    /**
     * 被担保人id
     * 表字段:user_id
     */
    private String userId;
    /**
     * 担保人姓名
     * 表字段:guarantee_name
     */
    private String guaranteeName;
    /**
     * 担保人职业
     * 表字段:guarantee_work
     */
    private String guaranteeWork;
    /**
     * 与担保人的关系
     * 表字段:relation
     */
    private String relation;
    /**
     * 担保人手机号
     * 表字段:guarantee_phone
     */
    private String guaranteePhone;
    public Integer getGuaranteeId() {
        return guaranteeId;
    }
    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getGuaranteeName() {
        return guaranteeName;
    }
    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }
    public String getGuaranteeWork() {
        return guaranteeWork;
    }
    public void setGuaranteeWork(String guaranteeWork) {
        this.guaranteeWork = guaranteeWork;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getGuaranteePhone() {
        return guaranteePhone;
    }
    public void setGuaranteePhone(String guaranteePhone) {
        this.guaranteePhone = guaranteePhone;
    }
    @Override
    public String toString() {
        return "GuaranteeInfo{" +
                "guaranteeId=" + guaranteeId +
                ", userId='" + userId + '\'' +
                ", guaranteeName='" + guaranteeName + '\'' +
                ", guaranteeWork='" + guaranteeWork + '\'' +
                ", relation='" + relation + '\'' +
                ", guaranteePhone='" + guaranteePhone + '\'' +
                '}';
    }
}
