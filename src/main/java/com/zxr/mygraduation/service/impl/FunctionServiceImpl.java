package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.RepaymentPlanMapper;
import com.zxr.mygraduation.dao.UserCreditMapper;
import com.zxr.mygraduation.entity.UserCredit;
import com.zxr.mygraduation.entity.UserInfo;
import com.zxr.mygraduation.model.CreditVO;
import com.zxr.mygraduation.model.LoanResultVO;
import com.zxr.mygraduation.model.RepaymentPlanVO;
import com.zxr.mygraduation.service.IFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
/**
 * FunctionServiceImpl class
 * @author xueran.zhang
 * @date 2020/03/25
 */
@Service
public class FunctionServiceImpl implements IFunctionService {
    @Autowired
    RepaymentPlanMapper repaymentPlanMapper;
    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    UserCreditMapper userCreditMapper;
    @Override
    public boolean getCreditVO1(Integer userId){
        System.out.println(userId);
        UserInfo userInfo =new UserInfo();
        userInfo=userInfoService.getByUserId(userId);
        System.out.println(userInfo);
        String birth=userInfo.getBirth();
        System.out.println(birth);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date2 = LocalDate.parse(birth,fmt);
        Double salary=userInfo.getSalary();
        Integer maritlStatus=userInfo.getMaritlStatus();
        CreditVO creditVO=getCreditVO(date2,salary,maritlStatus);

        UserCredit userCredit=new UserCredit();
        userCredit.setCreditValue(creditVO.getCreditValue());
        userCredit.setAllLimit(creditVO.getAllLimit());
       userCredit.setPreLimit(creditVO.getAllLimit());
       userCredit.setUserId(userId);
        System.out.println("得到的额度和信用值分别为"+userCredit);
        int result =userCreditMapper.updateUserCredit(userCredit);
        if (result == 1) {
            return true;
        }
        return false;

    }
    /**
     * 额度计算器
     * @param maritlStatus rule
     * @param  salary
     * @param   birth
     * @return  CreditVo
     */
    @Override
    public CreditVO getCreditVO(LocalDate birth, Double salary, Integer maritlStatus) {
       CreditVO creditVO=new CreditVO();
        Random rand = new Random();
        LocalDate time= LocalDate.now();
        int age = birth.until(time).getYears();
        boolean flag1=(age>24  && age<50 && salary>=30000) || (age>24  && age<50 && salary>=20000 && maritlStatus==1);
        if(age<18) {
            creditVO.setAllLimit(0.00);
            creditVO.setCreditValue(0);
        }
            else if(age>=18 && age<=24){
            creditVO.setAllLimit(1000.00);
            creditVO.setCreditValue(rand.nextInt(11) + 75);
            }
        else if(age>24 && age<50 && salary>=2000 && salary<=5000 ){
            creditVO.setAllLimit(2000.00);
            creditVO.setCreditValue(rand.nextInt(11) + 85);
        }
        else if(age>24 && age<50 && salary>=3000 && salary<=5000 && maritlStatus==0 ){
            creditVO.setAllLimit(5000.00);
            creditVO.setCreditValue(rand.nextInt(11) + 85);
        }
        else if(age>24 && age<50 && salary>=5000 && salary<=10000 ){
            creditVO.setAllLimit(20000.00);
            creditVO.setCreditValue(rand.nextInt(10) + 90);
        }
            else if(age>24 && age<50 && salary>=10000){
            creditVO.setAllLimit(50000.00);
            creditVO.setCreditValue(rand.nextInt(10) + 90);
        }
        else if(age>24 && age<50  && salary>=10000 && maritlStatus==1){
            creditVO.setAllLimit(50000.00);
            creditVO.setCreditValue(rand.nextInt(10) + 90);
        }
        else if(flag1){
            creditVO.setAllLimit(200000.00);
            creditVO.setCreditValue(rand.nextInt(10) + 90);
        }
            return creditVO;
        }
    /**
     * 额度,信用值变化规则
     * @param allLimit rule
     * @param  creditValue
     * @return  CreditVo
     */
    @Override
    public CreditVO getNextValue(Double allLimit,Integer creditValue){
        CreditVO creditVO=new CreditVO();
        if(allLimit==1000.00){
            allLimit=2000.00;
           if(creditValue<99){
               creditValue=creditValue+1;
           }else{
               creditValue=creditValue+0;
           }
        }
        else if(allLimit>=2000 && allLimit<=10000){
            allLimit=allLimit+1000;
            if(creditValue<95){
                creditValue=creditValue+1;
            }else{
                creditValue=creditValue+0;
            }
        }
        else if(allLimit>10000 && allLimit<=50000){
            allLimit=allLimit*1.2;
            if(creditValue<99){
                creditValue=creditValue+1;
            }else{
                creditValue=creditValue+0;
            }
        }
        else if(allLimit>50000 && allLimit<=100000){
            allLimit=allLimit+allLimit*1.1;
            if(creditValue<99){
                creditValue=creditValue+1;
            }else{
                creditValue=creditValue+0;
            }
        }
        else if(allLimit<=200000 && allLimit>=100000){
            allLimit=allLimit+0;
            creditValue=creditValue+0;
        }
        creditVO.setCreditValue(creditValue);
        creditVO.setAllLimit(allLimit);
        return creditVO;
    }
    /**
     * 还款计划
     * @param
     * @return
     */
    @Override
    public boolean InstallCal(Integer transflowId, Integer investId,
                                       Integer loanId, Integer perPeriod,
                                       Double repMoney, Double money){
       List list = new ArrayList();
        LocalDate date=LocalDate.now();
        LocalDate date1=date.plus(1, ChronoUnit.MONTHS);
        for(int i=1;i<=perPeriod;i++){
            RepaymentPlanVO repaymentPlanVO=new RepaymentPlanVO();
            repaymentPlanVO.setTransflowId(transflowId);
            repaymentPlanVO.setInvestId(investId);
            repaymentPlanVO.setLoanId(loanId);
            repaymentPlanVO.setRepMoney(money);
            repaymentPlanVO.setPerPeriod(i);
            repaymentPlanVO.setBorrowDate(date1);
            date1=date1.plus(1,ChronoUnit.MONTHS);
            list.add(repaymentPlanVO);
            System.out.println("我们单个的还款计划"+repaymentPlanVO);
        }
        System.out.println("我们看一下所有的还款计划"+list);
        int effectedNum = repaymentPlanMapper.insertRepaymentPlan(list);
        if (effectedNum > 0) {
            return true;
        } else {
            throw new RuntimeException("插入信息失败！");
        }
    }
    /**
     * 0.2x  1.1x 0.9x分别是平台争得钱，借款人付得钱，投资人得到的钱
     * @param money 借款金额
     * @param period 借款期数
     *@param rate 借款费率
     * @return  LoanResultVo
     */
    @Override
    public LoanResultVO getLoanResult(Double money,Integer period,Double rate){
       Double repayMoney;
       Double totalCharge;
       Double singleRepay;
       Double platformServiceFee;
       totalCharge=money*rate/100;
        BigDecimal b =   new   BigDecimal(totalCharge);
        double  totalChargeOne  =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
       platformServiceFee=totalCharge*0.05/2;
        BigDecimal c =   new   BigDecimal(platformServiceFee);
        double  platformServiceFeeOne  =   c.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
       repayMoney=money+totalChargeOne+platformServiceFeeOne;
       singleRepay=repayMoney/period;
        BigDecimal d=   new   BigDecimal(singleRepay);
        double  singleRepayOne  =   d.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
       LoanResultVO loanResultVO=new LoanResultVO();
       loanResultVO.setPlatformServiceFee(platformServiceFeeOne);
       loanResultVO.setRepayMoney(repayMoney);
       loanResultVO.setTotalCharge(totalChargeOne);
       loanResultVO.setSingleRepay(singleRepayOne);
       return  loanResultVO;
    }
}
