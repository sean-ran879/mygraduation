package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.AccountInfo;
import org.springframework.stereotype.Service;

@Service
public interface IAccountInfoService {
    String updateAcount(AccountInfo accountInfo);
    AccountInfo selectByUserId(Integer userId);
}
