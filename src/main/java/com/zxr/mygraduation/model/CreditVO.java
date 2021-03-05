package com.zxr.mygraduation.model;
import java.time.LocalDate;
/**
 * 传输给前端的Json（授信额度，信用值）
 * @author xueran.zhang
 * @date 2020/3/24
 */
public class CreditVO{
    private Double allLimit;
    private Integer creditValue;
    public Double getAllLimit() {
        return allLimit;
    }
    public void setAllLimit(Double allLimit) {
        this.allLimit = allLimit;
    }
    public Integer getCreditValue() {
        return creditValue;
    }
    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }
    @Override
    public String toString() {
        return "CreditVO{" +
                "allLimit=" + allLimit +
                ", creditValue=" + creditValue +
                '}';
    }
}
