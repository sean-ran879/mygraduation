package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.GuaranteeInfo;
import org.springframework.stereotype.Repository;
/**
 * GuaranteeInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface GuaranteeInfoMapper {
    /**
     *fetch data by rule id
     * 插入记录
     * @param guaranteeInfo rule
     * @return Result<GuaranteeInfo>
     */
    GuaranteeInfo selectByUserId(Integer userId);
    int insertGuarantee(GuaranteeInfo guaranteeInfo);
    /**
     * 更新记录
     * @param guaranteeInfo rule
     * @return Result<GuaranteeInfo>
     */
    int updateGuarantee(GuaranteeInfo guaranteeInfo);
}
