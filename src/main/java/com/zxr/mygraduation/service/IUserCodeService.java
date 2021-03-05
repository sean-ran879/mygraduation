package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.UserCode;

import org.springframework.stereotype.Service;

/**
 * IUserInfoService class
 * @author xueran.zhang
 * @date 2020/03/12
 */
@Service
public interface IUserCodeService {
    /**
     * fetch data by rule id
     * @param userCode rule
     * 添加客户信息
     * @return Result<UserInfo>
     */
    boolean addUserCode(UserCode userCode);
    /**
     * fetch data by rule id
     * @param userPhone rule
     * 根据手机号查找记录
     * @return UserInfo
     */
    UserCode getByUserPhone(String userPhone);
    /**
     * fetch data by rule id
     *
     * @param userPhone rule
     * @return Result<UserCode>
     * 根据user_phone删除客户信息
     */
    boolean deleteUserCode(String userPhone);
}
