package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.model.NumVO;
import net.sf.json.JSONObject;
import com.zxr.mygraduation.entity.Admin;
import com.zxr.mygraduation.service.impl.AdminServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/root")
@Controller
/**
 * RootController class
 * @author xueran.zhang
 * @date 2020/04/15
 */
public class RootController {
    @Autowired
    private AdminServiceImpl adminService;
    @ResponseBody
    @GetMapping("/loginRoot")
    @ApiOperation(value = "登录验证", notes = "登录验证")
    private    JSONObject loginRoot( Admin admin) {
        String root=admin.getRoot();
        String password=admin.getPassword();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("login", adminService.loginRoot(root,password));
        JSONObject jsonMap = JSONObject.fromObject(modelMap);
//        System.out.println(callback+ "(" + jsonMap + ")");
    System.out.println( jsonMap);
//        return callback+ "(" + jsonMap + ")";
        return  jsonMap;
    }

    @ResponseBody
    @GetMapping("/loginNum")
    @ApiOperation(value = "后台欢迎页参数", notes = "后台欢迎页参数")
    private  JSONObject loginNum() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        NumVO numVO= adminService.loginNum();
        Integer loanNum=numVO.getLoanNum();
        Integer investNum=numVO.getInvestNum();
        Integer orderNum=numVO.getOrderNum();
        modelMap.put("loanNum",loanNum);
        modelMap.put("investNum", investNum);
        modelMap.put("orderNum",orderNum);
        JSONObject jsonMap = JSONObject.fromObject(modelMap);
//        System.out.println(callback+ "(" + jsonMap + ")");
//        return callback+ "(" + jsonMap + ")";
        return jsonMap;
    }
}
