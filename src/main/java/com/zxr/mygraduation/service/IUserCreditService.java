package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.UserCredit;
import org.springframework.stereotype.Service;
/**
 * IUserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IUserCreditService {
    /**
     * fetch data by rule id
     * @param userCredit rule
     * 添加信息
     * @return Result<User>
     */
    boolean addUserCredit(UserCredit userCredit);

    /**
     * fetch data by rule id
     * @param userId rule
     * 根据用户id查找记录
     * @return User
     */
    UserCredit getByUserId(Integer userId);
    /**
     * 更新信用值
     * @param userCredit rule
     * 更新表记录
     * @return Result<User>
     */
    String updateUserCredit(UserCredit userCredit);

}
