package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.UserCreditMapper;
import com.zxr.mygraduation.entity.BankBind;
import com.zxr.mygraduation.entity.UserCredit;
import com.zxr.mygraduation.entity.UserInfo;
import com.zxr.mygraduation.service.IUserCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public class UserCreditServiceImpl implements IUserCreditService {
    @Autowired
    UserCreditMapper userCreditMapper;

    @Override
    public boolean addUserCredit(UserCredit userCredit) {
        if (userCredit.getUserId() != null && !"".equals(userCredit.getUserId())) {
            try {
                int effectedNum = userCreditMapper.insertUserCredit(userCredit);
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
    public UserCredit getByUserId(Integer userId) {
        UserCredit userCredit =new UserCredit();
             if(userCreditMapper.selectByUserId(userId)==null){
                 return  null;
             }else{
                 return userCreditMapper.selectByUserId(userId);
             }

    }

    @Override
    public String updateUserCredit(UserCredit userCredit) {
        int result =userCreditMapper.updateUserCredit( userCredit);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }

}
