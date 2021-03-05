package com.zxr.mygraduation.service.impl;
import io.swagger.models.auth.In;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.zxr.mygraduation.dao.UserInfoMapper;
import com.zxr.mygraduation.entity.UserInfo;
import com.zxr.mygraduation.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
/**
 * UserInfoService class
 * @author xueran.zhang
 * @date 2020/03/09
 */
public class UserInfoServiceImpl implements IUserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    /**
     *根据userId查询记录
     */
    public UserInfo getByUserId(Integer userId) {
      UserInfo userInfo = userInfoMapper.selectByUserId(userId);
        return userInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateUserPhoto(UserInfo userInfo) {
        int result =userInfoMapper.updateUserPhoto(userInfo);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateInfo(UserInfo userInfo) {
        int result =userInfoMapper.updateInfo(userInfo);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoMapper.selectUserInfo();
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        if (userInfo.getUserId() != null && !"".equals(userInfo.getUserId())) {
            try {
                int effectedNum = userInfoMapper.insertUserInfo(userInfo);
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
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addPhoto(UserInfo userInfo){
    int effectedNum = userInfoMapper.addPhoto(userInfo);
    if (effectedNum > 0) {
        return true;
    } else {
        throw new RuntimeException("插入信息失败！");
    }
}
    @Override
    public String updatePhoto(UserInfo userInfo) {
        int effectedNum = userInfoMapper.updatePhoto(userInfo);
        if (effectedNum == 1) {
            return "success";
        }
        return "fail";
    }

}
