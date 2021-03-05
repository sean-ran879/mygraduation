package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.AccountInfoMapper;
import com.zxr.mygraduation.entity.AccountInfo;
import com.zxr.mygraduation.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoServiceImpl implements IAccountInfoService {
    @Autowired
    private AccountInfoMapper accountInfoMapper;
    @Override
    public AccountInfo selectByUserId(Integer userId) {
        return accountInfoMapper.selectByUserId(userId);
    }
    @Override
    public String updateAcount(AccountInfo accountInfo) {
        int result =accountInfoMapper.updateAccount(accountInfo);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }
}
