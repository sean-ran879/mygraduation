package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class RateLimit {
    /**
     *主键id
     *表字段：id
     */
    private Integer id;
    /**
     *期数
     *表字段：total_period
     */
    private Integer totalPeriod;
    /**
     *费率最低值
     *表字段：rate_min
     */
    private Double rateMin;
    /**
     *费率最高值
     *表字段：rate_max
     */
    private Double rateMax;
    private Timestamp createTime;
    private Timestamp updateTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTotalPeriod() {
        return totalPeriod;
    }
    public void setTotalPeriod(Integer totalPeriod) {
        this.totalPeriod = totalPeriod;
    }
    public Double getRateMin() {
        return rateMin;
    }
    public void setRateMin(Double rateMin) {
        this.rateMin = rateMin;
    }
    public Double getRateMax() {
        return rateMax;
    }
    public void setRateMax(Double rateMax) {
        this.rateMax = rateMax;
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
        return "RateLimit{" +
                "id=" + id +
                ", totalPeriod=" + totalPeriod +
                ", rateMin=" + rateMin +
                ", rateMax=" + rateMax +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
