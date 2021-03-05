package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.RateLimitMapper;
import com.zxr.mygraduation.entity.RateLimit;
import com.zxr.mygraduation.service.IRateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/30
 */
@Service
public class RateLimitServiceImpl implements IRateLimitService {
    @Autowired
    private RateLimitMapper rateLimitMapper;
    @Override
    public List<RateLimit> getRateLimit() {
        return rateLimitMapper.selectRateLimit();
    }
    @Override
    public RateLimit getByTotal(Integer totalPeriod) {
        return rateLimitMapper.selectByTotal(totalPeriod);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateRateLimit(RateLimit rateLimit) {
        int result =rateLimitMapper.updateRateLimit(rateLimit);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }
}
