package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.AccountInfoMapper;
import com.zxr.mygraduation.dao.UserCreditMapper;
import com.zxr.mygraduation.dao.UserMapper;
import com.zxr.mygraduation.entity.AccountInfo;
import com.zxr.mygraduation.entity.User;
import com.zxr.mygraduation.entity.UserCredit;
import com.zxr.mygraduation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Random;

/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountInfoMapper accountInfoMapper;
    @Override
    /**
     *根据userPhone查询记录
     */
    public User getByUserPhone(String userPhone) {
        System.out.println("插入第二个表的用户手机号Service"+userPhone);
        User user = userMapper.selectByUserPhone(userPhone);
        System.out.println("插入第二个表的用户手机号Service"+user);
        return user;
    }
    @Override
    /**
     *根据userId查询记录
     */
    public User selectById(Integer userId) {

        User user = userMapper.selectById(userId);

        return user;
    }


    /**
     *获取全部记录
     */
    @Override
    public List<User> getUserList() {
        return userMapper.selectUser();
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user) {
        if (user.getUserId() != null && !"".equals(user.getUserId())) {
            try {
                int effectedNum = userMapper.insertUser(user);
                AccountInfo accountInfo=new AccountInfo();
                accountInfo.setUserId(user.getUserId());
                String id=Integer.toString(user.getUserId());
                String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
                String myaccount=id+verifyCode;
               accountInfo.setMyaccount(myaccount);
                int e=accountInfoMapper.insertAccount(accountInfo);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("信息不能为空");
        }
    }



    @Override
    public String loginUser(String userPhone,String passWord){
        String LONE= "借款";
        String LONE1="投资人";
        String flag;
        User user= userMapper.selectByUserPhone(userPhone);
        String pwd=user.getPassWord();
        String role=user.getUserRole();
        if(passWord.equals(pwd)&& role.equals(LONE)){
            flag="11";
        }else if(passWord.equals(pwd)&& role.equals(LONE1)){
            flag="12";
        }
        else {
            flag="0";
        }
        return flag;
    }
    @Override
    public boolean addUserPw(String transPw, Integer userId) {
        int effectedNum = userMapper.insertUserPw(transPw,userId);
        if (effectedNum > 0) {
            return true;
        } else {
            throw new RuntimeException("插入信息失败！");
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateUser(User user) {
        int result =userMapper.updateUser(user);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }


}
