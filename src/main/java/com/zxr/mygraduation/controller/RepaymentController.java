package com.zxr.mygraduation.controller;

import com.zxr.mygraduation.entity.RepaymentPlan;
import com.zxr.mygraduation.service.impl.RepaymentPlanServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/repayment")
@Controller
public class RepaymentController {
    @Autowired
    private RepaymentPlanServiceImpl repaymentPlanService;
    @ApiOperation(value = "获取用户表中的某条信息", notes = "根据手机号来获取详细信息")
    @GetMapping("/getMoney")
    public Map<String, Object> getMoney(RepaymentPlan repaymentPlan) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
       Double money = repaymentPlanService.selectMoney(repaymentPlan) ;
        DecimalFormat df = new DecimalFormat("#.00");
        String  money1=df.format(money);
        modelMap.put("money", money1);
        return modelMap;
    }


}
