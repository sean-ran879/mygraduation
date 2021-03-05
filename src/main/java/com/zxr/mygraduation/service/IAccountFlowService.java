package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.AccountFlow;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IAccountFlowService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IAccountFlowService {
    /**
     * fetch data by rule id
     * @return Result<User>
     * 查询所有信息
     */
    List<AccountFlow> getAccountFlowList();
    /**
     * fetch data by rule id
     * @param accountFlow rule
     * 添加客户注册信息
     * @return Result<AccountFlow>
     */
    boolean addAccountFlow(AccountFlow accountFlow );


}