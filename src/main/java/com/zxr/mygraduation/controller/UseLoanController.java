package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.UseLoan;
//import com.baomidou.mybatisplus.plugins.Page;
import com.zxr.mygraduation.service.impl.UseLoanServiceImpl;
import com.zxr.mygraduation.tool.Result;
import com.zxr.mygraduation.tool.ResultResponse;
import com.zxr.mygraduation.tool.TableResultResponse;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/useLoan")
@Controller
/**
 * UserLoanController class
 * @author keriezhang
 * @date 2016/10/31
 */
public class UseLoanController {
    @Autowired
    /**
     * Service的实体，用来调用实现方法
     */
    private UseLoanServiceImpl useLoanService;
    /**
     * 查询所有记录
     */
    @PostMapping("/getUseLoan")
    @ApiOperation(value = "获取借款用途表记录", notes = "获取用户借款用途统计列表")
    private Map<String, Object> ListUseLoan() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<UseLoan> list = useLoanService.getUseLoanList();
        modelMap.put("useLoanList", list);
        System.out.println(modelMap);
        return modelMap;
    }
    @ResponseBody
    @GetMapping("/addUseLoan")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private ResultResponse addUseLoan(UseLoan useLoan) {
        System.out.println(useLoan);
        boolean result= useLoanService.addUseLoan(useLoan);
        if (!result) {
            return Result.resuleError("新增失败");
        }
        return Result.resuleSuccess();
    }
    @ResponseBody
    @GetMapping("/delUseLoan")
    public ResultResponse delUseLoan(String useLoan) {
        System.out.println(useLoan);
        boolean result =  useLoanService.deleteUseLoan(useLoan);
        if (!result) {
            return Result.resuleError("删除失败");
        }
        return Result.resuleSuccess();
    }
    @ResponseBody
    @GetMapping("/editUseLoan")
    public ResultResponse editUseLoan(UseLoan useLoan) {
        System.out.println(useLoan);
        String result =  useLoanService.updateUseLoan(useLoan);
        if (result=="fail") {
            return Result.resuleError("编辑失败");
        }
        return Result.resuleSuccess();
    }
    @ResponseBody
    @GetMapping("/getUseLoan1")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getUseLoan( ) {

        //        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<UseLoan> list = useLoanService.getUseLoanList();
//        modelMap.put("useLoanList", list);
//        JSONObject jsonMap = JSONObject.fromObject(modelMap);
//        System.out.println(callback+ "(" + jsonMap + ")");
//        return callback+ "(" + jsonMap + ")";
        List<Map<String, Object>> infoList = new ArrayList<>();
        List<UseLoan> permissionList = useLoanService.getUseLoanList();


        for (UseLoan permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("id", permissionEntity.getId());
            permissionMap.put("useLoan", permissionEntity.getUseLoan());
            permissionMap.put("createTime", permissionEntity.getCreateTime());
            permissionMap.put("updateTime", permissionEntity.getUpdateTime());
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }


}
