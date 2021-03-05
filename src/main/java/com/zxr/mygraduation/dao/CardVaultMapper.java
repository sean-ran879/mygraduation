package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.CardVault;
import org.springframework.stereotype.Repository;

/**
 * GuaranteeInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface CardVaultMapper {
    /**
     * 根据身份证号和姓名得到记录
     * @param idCard rule
     * @param name rule
     * @return userInfo
     */
    CardVault selectByName(String idCard, String name);

}
