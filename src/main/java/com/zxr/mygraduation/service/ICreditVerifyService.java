package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.CreditVerify;
import org.springframework.stereotype.Service;
/**
 * ICreditVerifyService class
 * @author xueran.zhang
 * @date 2020/03/24
 */
@Service
public interface ICreditVerifyService {
    /**
     * 添加客户注册信息
     * @param creditVerify rule
     * @return Result<User>
     */
    boolean addCreditVerify(CreditVerify creditVerify);
    /**
     * 根据手机号查找记录
     * @param verifyType rule
     * @return CreditVerify
     */
    CreditVerify getByVerifyTypeInteger(Integer verifyType);

}

