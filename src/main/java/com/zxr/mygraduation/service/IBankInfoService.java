package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.BankInfo;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IBankInfoService class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public interface IBankInfoService {
    /**
     * fetch data by rule id
     * @return Result<BankInfo>
     * 查询所有银行卡名称
     */
    List<BankInfo> getBankInfoList();
    /**
     * fetch data by rule id
     * @param bankInfo rule
     * 添加支持的银行卡信息
     * @return Result<User>
     */
    boolean addBankInfo(BankInfo bankInfo);
    /**
     * fetch data by rule id
     * @param   bankInfo rule
     * 根据查找银行卡名称查找记录
     * @return User
     */
    String getByBankName(BankInfo bankInfo);
    /**
     * 根据银行卡名称删除记录
     * @param bankName rule
     * @return
     */
    boolean deleteBankInfo(String bankName);

}
