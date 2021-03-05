package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.CardVaultMapper;
import com.zxr.mygraduation.entity.CardVault;
import com.zxr.mygraduation.service.ICardVaultService;
/**
 * CardVaultServiceImpl class
 * @author xueran.zhang
 * @date 2020/03/24
 */
public class CardVaultServiceImpl implements ICardVaultService {
    CardVaultMapper cardVaultMapper;
    @Override
    public CardVault getByUserPhone(String idCard, String name) {
        CardVault cardVault =cardVaultMapper.selectByName(idCard,name);
        return cardVault;
    }
}
