package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.AccountInfo;
import com.zxr.mygraduation.entity.User;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IUserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IUserService {
    /**
     * fetch data by rule id
     * @return Result<User>
     * 查询所有信息
     */
    List<User> getUserList();
    /**
     * fetch data by rule id
     * @param user rule
     * 添加客户注册信息
     * @return Result<User>
     */
    boolean addUser(User user );
//    boolean insertAccount(AccountInfo accountInfo);
    /**
     * fetch data by rule id
     * @param userPhone rule
     * 根据手机号查找记录
     * @return User
     */
    User getByUserPhone(String userPhone);
    User selectById(Integer userId);


    /**
     * fetch data by rule id
     * @param   passWord rule
     * @param   userPhone rule
     * 登录验证
     * @return String
     */
    String loginUser(String userPhone,String passWord);
    /**
     * 绑定银行卡或者初次使用我的账户的时候需要设置交易密码
     * @param transPw rule
     * @param userId rule
     * 添加客户交易密码信息
     * @return Result<User>
     */
    boolean addUserPw(String transPw,Integer userId);
    /**
     * 用户修改交易密码，登录密码，手机号等
     * @param user rule
     * 更新表记录
     * @return Result<User>
     */
    String updateUser(User user);


}

