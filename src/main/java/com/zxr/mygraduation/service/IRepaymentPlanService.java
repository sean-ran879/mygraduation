package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.RepaymentPlan;
import org.springframework.stereotype.Service;

@Service
public interface IRepaymentPlanService {
    Double selectMoney(RepaymentPlan repaymentPlan);
}
