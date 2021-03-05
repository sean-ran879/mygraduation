package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * UserMapper interface
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Repository
public interface UserMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param user rule
     * @return Result<UserInfo>
     */
    int insertUser(User user);
    /**
     * 显示所有记录
     * @param
     * @return
     */
    List<User> selectUser();
    /**
     * 根据手机号得到记录
     * @param userPhone rule id
     * @return userInfo
     */
    User selectByUserPhone(String userPhone);
    User  selectById(Integer userId);
    /**
     * fetch data by rule id
     * 添加用户的交易密码,根据用户id进行添加
     * @param transPw rule
     * @param userId rule
     * @return Result<User>
     */
    int insertUserPw(String transPw,Integer userId);
    /**
     * fetch data by rule id
     * 更新记录（更新手机号，密码，交易密码等）
     * @param user rule
     * @return Result<User>
     */
    int updateUser(User user);

}
