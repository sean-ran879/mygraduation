package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.User;
import com.zxr.mygraduation.entity.UserCredit;
import org.springframework.stereotype.Repository;

/**
 * UserCreditMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface UserCreditMapper {
    /**
     * 插入记录
     * @param userCredit rule
     * @return
     */
    int insertUserCredit(UserCredit userCredit);

    /**
     * 根据用户id得到记录
     * @param userId rule id
     * @return userInfo
     */
   UserCredit selectByUserId(Integer userId);
    /**
     * fetch data by rule id
     * 更新记录（更新手机号，密码，交易密码等）
     * @param userCredit rule
     * @return Result<User>
     */
    int updateUserCredit(UserCredit userCredit);


}
