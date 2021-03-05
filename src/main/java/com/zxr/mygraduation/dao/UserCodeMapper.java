package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.UserCode;
import org.springframework.stereotype.Repository;
/**
 * @author keriezhang
 * @date 2016/10/31
 */
@Repository
public interface UserCodeMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param userCode rule
     * @return Result<UserInfo>
     */
    int insertUserCode(UserCode userCode);
    /**
     * 判断手机号是否已经存在
     * @param userPhone rule id
     * @return userInfo
     */
    UserCode selectByUserPhone(String userPhone);
    /**
     * 删除记录
     * @param userPhone rule
     * @return Result<UserCode>
     */
    int deleteUserCode(String userPhone);

}
