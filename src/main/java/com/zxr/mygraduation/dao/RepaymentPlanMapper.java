package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.RepaymentPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RepaymentPlanMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface RepaymentPlanMapper {
    /**
     * fetch data by rule id
     * 添加还款计划
     * @return Result<User>
     */
    int insertRepaymentPlan(List<RepaymentPlan> list);
    Double selectMoney(RepaymentPlan repaymentPlan);
}