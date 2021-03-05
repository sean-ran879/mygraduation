package com.zxr.mygraduation.entity;
import java.sql.Timestamp;
/**
 * 表:user_info
 *用户信息表
 * @author xueran.zhang
 * @date 2020-03-09
 */
public class UserInfo {
    /**
     * 主键ID
     * 表字段:user_id
     */
     private Integer userId;
    /**
     * 姓名
     * 表字段:user_name
     */
     private String userName;
    /**
     * 性别
     * 表字段:gender
     */
    private String gender;
    /**
     * 出生日期
     * 表字段:birth
     */
    private  String birth;
    /**
     * 身份证号
     * 表字段:id_card
     */
    private  String idCard;
    /**
     * 现住地址
     * 表字段:pre_address
     */
    private String preAddress;
    /**
     * 职业
     * 表字段:work
     */
     private  String work;
    /**
     * 身份证正面照片
     * 表字段:card_frontphoto
     */
     private String cardFrontPhoto;
    /**
     * 身份证反面照片
     * 表字段:card_backphoto
     */
     private String cardBackPhoto;
    /**
     * 现拍照片
     * 表字段:pre_photo
     */
     private String prePhoto;
    /**
     * 月收入
     * 表字段:salary
     */
     private  Double salary;
    /**
     * 公司名称
     * 表字段:company
     */
     private String company;
    /**
     * 户籍地址
     * 表字段:hj_address
     */
     private String hjAddress;
    /**
     * 婚姻状况
     * 表字段:maritl_status
     */
     private Integer maritlStatus;
     /**
     * 创建时间
     * 表字段:create_time
     */
     private Timestamp createTime;
    /**
     * 更新时间
     * 表字段:update_time
     */
     private Timestamp updateTime;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getPreAddress() {
        return preAddress;
    }
    public void setPreAddress(String preAddress) {
        this.preAddress = preAddress;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public String getCardFrontPhoto() {
        return cardFrontPhoto;
    }
    public void setCardFrontPhoto(String cardFrontPhoto) {
        this.cardFrontPhoto = cardFrontPhoto;
    }
    public String getCardBackPhoto() {
        return cardBackPhoto;
    }
    public void setCardBackPhoto(String cardBackPhoto) {
        this.cardBackPhoto = cardBackPhoto;
    }
    public String getPrePhoto() {
        return prePhoto;
    }
    public void setPrePhoto(String prePhoto) {
        this.prePhoto = prePhoto;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getHjAddress() {
        return hjAddress;
    }
    public void setHjAddress(String hjAddress) {
        this.hjAddress = hjAddress;
    }
    public Integer getMaritlStatus() {
        return maritlStatus;
    }
    public void setMaritlStatus(Integer maritlStatus) {
        this.maritlStatus = maritlStatus;
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
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", preAddress='" + preAddress + '\'' +
                ", work='" + work + '\'' +
                ", cardFrontPhoto='" + cardFrontPhoto + '\'' +
                ", cardBackPhoto='" + cardBackPhoto + '\'' +
                ", prePhoto='" + prePhoto + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", hjAddress='" + hjAddress + '\'' +
                ", maritlStatus=" + maritlStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
