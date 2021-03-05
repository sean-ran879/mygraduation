package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.BankInfoMapper;
import com.zxr.mygraduation.entity.BankInfo;
import com.zxr.mygraduation.service.IBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public class BankInfoServiceImpl implements IBankInfoService {
    @Autowired
    BankInfoMapper bankInfoMapper;
    @Override
    /**
     *获取全部记录
     */
    public List<BankInfo> getBankInfoList() {
            return bankInfoMapper.selectBankInfo();
    }
    /**
     *添加支持的银行卡信息
     */
    @Override
    public boolean addBankInfo(BankInfo bankInfo) {
        if (bankInfo.getId() != null && !"".equals(bankInfo.getId())) {
            try {
                int effectedNum = bankInfoMapper.insertBankInfo(bankInfo);
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
     * 根据查找银行卡名称查找记录
     */
    @Override
    public String getByBankName(BankInfo bankInfo) {
        String bankName=bankInfo.getBankName();
        String s;
        Integer b= bankInfoMapper.selectByBankName(bankName);
        if(b==0){
            s="no";
        }else{
            s="yes";
        }
        System.out.println("bankInfo==="+s);
        return s;
    }
    /**
     * 根据银行卡名称删除记录
     */
    @Override
    public  boolean deleteBankInfo(String bankName) {
        if (bankName!="") {
            try {
                int effectedNum = bankInfoMapper.deleteBankInfo(bankName);
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
}
