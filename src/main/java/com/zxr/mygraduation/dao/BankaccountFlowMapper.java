package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.BankaccountFlow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GuaranteeInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface BankaccountFlowMapper {
   List<BankaccountFlow> selectById(Integer userId);
    int insertBankFlow(BankaccountFlow bankaccountFlow);

}
