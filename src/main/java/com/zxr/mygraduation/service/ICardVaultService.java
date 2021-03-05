package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.CardVault;
import org.springframework.stereotype.Service;
/**
 * ICardVaultService  class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface ICardVaultService {
    /**
     * 根据手机号查找记录
     * @param idCard rule
     * @param name rule
     * @return User
     */
   CardVault getByUserPhone(String idCard, String name);
}
