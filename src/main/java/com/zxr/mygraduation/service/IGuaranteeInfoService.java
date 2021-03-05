package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.GuaranteeInfo;
import org.springframework.stereotype.Service;

/**
 * IGuaranteeInfoService class
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Service
public interface IGuaranteeInfoService {
    /**
     * fetch data by rule id
     * @param guaranteeInfo rule
     * 添加信息
     * @return Result<GuaranteeInfo>
     */
    boolean addGuarantee(GuaranteeInfo guaranteeInfo);
    /**
     *  fetch data by rule id
     * @param guaranteeInfo rule
     * 更新信息
     * @return Result<GuaranteeInfo>
     */
    String updateGuarantee(GuaranteeInfo guaranteeInfo);
     GuaranteeInfo getByUserId(Integer userId);
}
