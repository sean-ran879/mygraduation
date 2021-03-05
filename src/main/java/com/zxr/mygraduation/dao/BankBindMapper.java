package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.BankBind;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * BankBindMapper interface
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Repository
public interface BankBindMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param bankBind rule
     * @return Result<UserInfo>
     */
    int insertBankBind(BankBind bankBind);
    /**
     * 根据用户id得到记录
     * @param userId rule id
     * @return bankbind
     */
    BankBind selectByUserId(Integer userId);
    /**
     * 根据用户id名称删除记录
     * @param userId rule
     * @return
     */
    int deleteBankBind(Integer userId);
    int updateBank(BankBind bankBind);
}