package com.zxr.mygraduation.service.impl;


import com.zxr.mygraduation.dao.BankBindMapper;
import com.zxr.mygraduation.dao.BankInfoMapper;
import com.zxr.mygraduation.entity.BankBind;
import com.zxr.mygraduation.service.IBankBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
/**
 * BankBindService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
public class BankBindServiceImpl implements IBankBindService {
    @Autowired
    private BankBindMapper bankBindMapper;
    @Autowired
    private BankInfoMapper bankInfoMapper;
    @Override
    /**
     *根据userid查询记录
     */
    public BankBind getByUserId(Integer userId) {
        BankBind bankBind = bankBindMapper.selectByUserId(userId);
        return bankBind;
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addBankBind(BankBind bankBind) {
        try {
            int count = bankInfoMapper.selectByBankName(bankBind.getBankName());
            System.out.println("查询结果银行卡是否存在"+count);
            if (count != 0) {
                int effectedNum = bankBindMapper.insertBankBind(bankBind);
                if (effectedNum > 0) {
                    return "yes";
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            }else{
                return  "no";
            }
        } catch (Exception e) {
            throw new RuntimeException("插入信息失败：" + e.getMessage());
        }
    }
    /**
     * 根据user_id删除记录
     */
    @Override
    public  boolean deleteBankBind(Integer userId) {
        if (userId != null) {
            try {
                int effectedNum = bankBindMapper.deleteBankBind(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("信息不能为空");
        }

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateBank(BankBind bankBind) {

            int result =bankBindMapper.updateBank(bankBind);
            if (result == 1) {
                return "success";
            }
            return "fail";
        }

}
