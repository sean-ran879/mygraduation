package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.User;
import com.zxr.mygraduation.model.CreditVO;
import com.zxr.mygraduation.model.LoanResultVO;
import com.zxr.mygraduation.service.impl.FunctionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/creditFun")
@Controller
/**
 * creditFunController class
 * @author xueran.zhang
 * @date 2020/03/24
 */
public class FunctionController {
    @Autowired
   private FunctionServiceImpl functionService;
    @GetMapping("/getCreditValue")
    @ApiOperation(value = "获取信用额度和信用值根据出生日期，薪水，婚姻状况", notes = "获取信用额度和信用值根据出生日期，薪水，婚姻状况")
    private Map<String, Object> getCreditValue(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",  functionService.getCreditVO1(userId));
        return modelMap;
    }
    /**
     * 0.2x  1.1x 0.9x分别是平台争得钱，借款人付得钱，投资人得到的钱
     * @param money 借款金额
     * @param period 借款期数
     *@param rate 借款费率
     * @return  LoanResultVo
     */
    @GetMapping("/getLoanResult")
    @ApiOperation(value = "获取还款总额，手续费总额，单期还款费，平台服务费", notes = "获取还款总额，手续费总额，单期还款费，平台服务费")
    private Map<String, Object> getLoanResult(Double money,Integer period,Double rate) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        LoanResultVO list = functionService.getLoanResult(money,period,rate);
        modelMap.put("moneyList", list);
        return modelMap;
    }
    @GetMapping("/installCal")
    @ApiOperation(value = "添加还款计划", notes = "添加还款计划")
    private Map<String, Object> InstallCal(Integer transflowId,Integer investId,
                                           Integer loanId, Integer perPeriod,
                                           Double repMoney,Double money){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",functionService.InstallCal(transflowId,investId, loanId, perPeriod,repMoney, money));
        return modelMap;
    }


}
