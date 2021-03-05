package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.RateLimit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IUserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IRateLimitService {
    /**
     * fetch data by rule id
     * @return Result<User>
     * 查询所有信息
     */
    List<RateLimit> getRateLimit();
    /**
     * fetch data by rule id
     * @param totalPeriod rule
     * 根据手机号查找记录
     * @return User
     */
    RateLimit getByTotal(Integer totalPeriod);
    /**
     * fetch data by rule id
     * @param rateLimit rule
     * 根据手机号查找记录
     * @return User
     */
    String updateRateLimit(RateLimit rateLimit);

}
