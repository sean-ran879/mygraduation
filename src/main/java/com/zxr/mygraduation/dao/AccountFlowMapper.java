package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.AccountFlow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GuaranteeInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface AccountFlowMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param accountFlow rule
     * @return Result<UserInfo>
     */
    int insertAccountFlow(AccountFlow accountFlow);
    /**
     * 显示所有记录
     * @param
     * @return
     */
    List<AccountFlow> selectAccountFlow();
}
