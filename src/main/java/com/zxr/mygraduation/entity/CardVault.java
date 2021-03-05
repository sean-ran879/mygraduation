package com.zxr.mygraduation.entity;
/**
 * @author xueran.zhang
 * @date 2020/3/23
 */
public class CardVault {
    private Integer id;
    private  String name;
    private String idCard;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    @Override
    public String toString() {
        return "CardVault{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
