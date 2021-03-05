package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.RateLimit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  RateLimitMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface RateLimitMapper {
    /**
     * 显示所有记录
     * @param
     * @return
     */
    List<RateLimit> selectRateLimit();
    /**
     * 根据手机号得到记录
     * @param totalPeriod rule id
     * @return userInfo
     */
    RateLimit selectByTotal(Integer totalPeriod);
    int updateRateLimit(RateLimit rateLimit);

}
