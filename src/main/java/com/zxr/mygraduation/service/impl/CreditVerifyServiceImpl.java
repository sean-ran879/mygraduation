package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.CreditVerifyMapper;
import com.zxr.mygraduation.entity.CreditVerify;
import com.zxr.mygraduation.service.ICreditVerifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CreditVerifyServiceImpl class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public class CreditVerifyServiceImpl implements ICreditVerifyService {
    CreditVerifyMapper creditVerifyMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addCreditVerify(CreditVerify creditVerify) {
        if (creditVerify.getId()!= null && !"".equals(creditVerify.getId())) {
            try {
                int effectedNum = creditVerifyMapper.insertCreditVerify(creditVerify);
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
    public CreditVerify getByVerifyTypeInteger(Integer verifyType) {
        CreditVerify  creditVerify= creditVerifyMapper.selectByVerifyType(verifyType);
        return creditVerify;
    }
}
