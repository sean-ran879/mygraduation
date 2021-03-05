package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.AccountFlowMapper;
import com.zxr.mygraduation.entity.AccountFlow;
import com.zxr.mygraduation.service.IAccountFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
/**
 * AccountFlowService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
public class AccountFlowServiceImpl implements IAccountFlowService {
    @Autowired
    private AccountFlowMapper accountFlowMapper;
    /**
     *获取全部记录
     */
    @Override
    public List<AccountFlow> getAccountFlowList() {
        return accountFlowMapper.selectAccountFlow();
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addAccountFlow(AccountFlow accountFlow) {
       // if (user.getUserId() != null && !"".equals(user.getUserId())) {
            try {
                int effectedNum = accountFlowMapper.insertAccountFlow(accountFlow);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败：" + e.getMessage());
            }
//        } else {
//            throw new RuntimeException("信息不能为空");
//        }
    }

}