package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.AccountInfo;
import org.springframework.stereotype.Repository;

/**
 * GuaranteeInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface AccountInfoMapper {
    int insertAccount(AccountInfo accountInfo);
    int updateAccount(AccountInfo accountInfo);
    AccountInfo selectByUserId(Integer userId);
}
