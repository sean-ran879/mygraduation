package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.BankBind;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IBankBindService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IBankBindService {
    /**
     * fetch data by rule id
     * @param bankBind rule
     * 添加客户注册信息
     * @return Result<BankBind>
     */
    String addBankBind(BankBind bankBind );
    /**
     * fetch data by rule id
     * @param userId rule
     * 根据用户id查找记录
     * @return User
     */
    BankBind getByUserId(Integer userId);
    /**
     * 根据user_id删除记录
     * @param userId rule
     * @return
     */
    boolean deleteBankBind(Integer userId);
    String updateBank(BankBind bankBind);

}