package com.zxr.mygraduation.service.impl;

import com.google.common.annotations.VisibleForTesting;
import com.zxr.mygraduation.dao.UserCodeMapper;

import com.zxr.mygraduation.entity.UserCode;

import com.zxr.mygraduation.service.IUserCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * UserInfoService class
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Service
public class UserCodeServiceImpl implements IUserCodeService {
    @Autowired
    private UserCodeMapper userCodeMapper;
    @Override
    /**
     *根据userPhone查询记录
     */
    public UserCode getByUserPhone(String userPhone) {
        UserCode userCode = userCodeMapper.selectByUserPhone(userPhone);
        return userCode;
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUserCode(UserCode userCode) {
        if (userCode.getUserPhone() != null && !"".equals(userCode.getUserCode())) {
            try {
                int effectedNum = userCodeMapper.insertUserCode(userCode);
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

    /**
     * 根据userPhone删除记录
     */
    @Override
    public boolean deleteUserCode(String userPhone) {
            try {
                int effectedNum = userCodeMapper.deleteUserCode(userPhone);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败：" + e.toString());
            }
        }
    }
