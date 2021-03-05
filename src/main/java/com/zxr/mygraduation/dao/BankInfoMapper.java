package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.BankInfo;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * BankInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface BankInfoMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param bankInfo rule
     * @return BankInfo
     */
    int insertBankInfo(BankInfo bankInfo);
    /**
     * 根据银行卡名称得到记录
     * @param bankName rule id
     * @return userInfo
     */
   Integer selectByBankName(String bankName);
    /**
     * 显示所有银行卡名称
     * @param
     * @return
     */
    List<BankInfo> selectBankInfo();
    /**
     * 根据银行卡名称删除记录
     * @param bankName rule
     * @return
     */
    int deleteBankInfo(String bankName);

}
