package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.CreditVerify;
import org.springframework.stereotype.Repository;
/**
 * CreditVerifyMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface CreditVerifyMapper {
    /**
     * 插入记录
     * @param creditVerify rule
     * @return
     */
    int insertCreditVerify(CreditVerify creditVerify);
    /**
     * 查询用户是否进行了身份认证
     * @param verifyType rule
     * @return CreditVerify
     */
     CreditVerify selectByVerifyType(Integer verifyType);
}
