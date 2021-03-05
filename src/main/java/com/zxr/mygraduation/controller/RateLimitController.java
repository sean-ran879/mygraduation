package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.RateLimit;
import com.zxr.mygraduation.entity.UseLoan;
import com.zxr.mygraduation.service.impl.RateLimitServiceImpl;
import com.zxr.mygraduation.tool.Result;
import com.zxr.mygraduation.tool.ResultResponse;
import com.zxr.mygraduation.tool.TableResultResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/RateLimit")
@Controller
/**
 * @author xueran.zhang
 * @date 2020/03/30
 */
public class RateLimitController {
    @Autowired
    private RateLimitServiceImpl rateLimitService;
    @ResponseBody
    @GetMapping("/getRateLimit")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private TableResultResponse ListRateLimit() {
         List<Map<String, Object>> infoList = new ArrayList<>();
        List<RateLimit> permissionList =  rateLimitService.getRateLimit();
        for (RateLimit permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("id", permissionEntity.getId());
            permissionMap.put("totalPeriod", permissionEntity.getTotalPeriod());
            permissionMap.put("rateMax", permissionEntity.getRateMax());
            permissionMap.put("rateMin", permissionEntity.getRateMin());
            permissionMap.put("createTime", permissionEntity.getCreateTime());
            permissionMap.put("updateTime", permissionEntity.getUpdateTime());
            infoList.add(permissionMap);
        }
        return Result.tableResule(0, infoList);
    }
    @GetMapping("/getByTotal")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> getByTotal(String totalPeriod) {
        System.out.println(totalPeriod);
        Integer  totalPeriod1=Integer.parseInt(totalPeriod);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        RateLimit list = rateLimitService.getByTotal(totalPeriod1);
        modelMap.put("RateLimit", list);
        System.out.println(list);
        return modelMap;
    }

    @ResponseBody
    @GetMapping("/editRateLimit")
    public ResultResponse editRateLimit(RateLimit rateLimit) {
        System.out.println(rateLimit);
        String result = rateLimitService.updateRateLimit(rateLimit);
        if (result=="fail") {
            return Result.resuleError("更新失败");
        }
        return Result.resuleSuccess();
    }

}
