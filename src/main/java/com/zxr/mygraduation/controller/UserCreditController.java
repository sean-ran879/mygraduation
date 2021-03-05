package com.zxr.mygraduation.controller;

import com.zxr.mygraduation.entity.UserCredit;
import com.zxr.mygraduation.service.impl.UserCreditServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/userCredit")
@Controller
/**
 * Demo class
 * @author keriezhang
 * @date 2016/10/31
 */
public class UserCreditController {
    @Autowired
    /**
     * Service的实体，用来调用实现方法
     */
    private UserCreditServiceImpl  userCreditService;
    @ApiOperation(value = "获取用户信用信息", notes = "根据用户id来获取用户信用信息")
    @GetMapping("/getByUserId")
    public Map<String, Object> getByUserId(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
       UserCredit userCredit=userCreditService.getByUserId(userId);
        modelMap.put("userCredit", userCredit);
        return modelMap;
    }
}
