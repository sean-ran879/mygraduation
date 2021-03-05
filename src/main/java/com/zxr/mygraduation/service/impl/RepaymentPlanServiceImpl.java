package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.RepaymentPlanMapper;
import com.zxr.mygraduation.entity.RepaymentPlan;
import com.zxr.mygraduation.service.IRepaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RepaymentPlanServiceImpl implements IRepaymentPlanService {
    @Autowired
  private  RepaymentPlanMapper repaymentPlanMapper;
    @Override
    public Double selectMoney(RepaymentPlan repaymentPlan) {
        return repaymentPlanMapper.selectMoney(repaymentPlan);
    }
}
