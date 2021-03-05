package com.zxr.mygraduation.service;
import com.zxr.mygraduation.model.CreditVO;

import com.zxr.mygraduation.model.LoanResultVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

/**
 * IFunctionService class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public interface IFunctionService {
    /**
     * fetch data by rule id
     *
     * @param maritlStatus rule
     * @param salary
     * @param birth        额度计算器
     * @return CreditVo
     */
    CreditVO getCreditVO(LocalDate birth, Double salary, Integer maritlStatus);
    boolean getCreditVO1(Integer userId);
    /**
     * 额度,信用值变化规则
     *
     * @param allLimit    rule
     * @param creditValue
     * @return CreditVo
     */
    CreditVO getNextValue(Double allLimit, Integer creditValue);
    /**
     * 0.2x  1.1x 0.9x分别是平台争得钱，借款人付得钱，投资人得到的钱
     * @param money 借款金额
     * @param period 借款期数
     *@param rate 借款费率
     * @return  LoanResultVo
     */
    LoanResultVO getLoanResult(Double money, Integer period, Double rate);
    /**
     * 还款计划
     * @param
     * @return
     */
  boolean  InstallCal(Integer transflowId, Integer investId,
                                   Integer loanId, Integer perPeriod,
                                   Double repMoney, Double money);
}