package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.SuggestInfo;
import com.zxr.mygraduation.service.impl.SuggestInfoServiceImpl;
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
@RequestMapping(value = "/suggestInfo")
@Controller
/**
 * SuggestController class
 * @author xueran.zhang
 * @date 2020/4/21
 */
public class SuggestController {
    @Autowired
    private SuggestInfoServiceImpl suggestInfoService;

    @ApiOperation(value = "用户反馈接口", notes = "用户反馈接口")
    @PostMapping("/addSuggest")
    public Map<String, Object> addSuggest(@RequestBody SuggestInfo suggestInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", suggestInfoService.addSuggest(suggestInfo));
        return modelMap;
    }
    @ResponseBody
    @GetMapping("/editSuggest")
    public ResultResponse editSuggest(SuggestInfo suggestInfo) {
        System.out.println(suggestInfo);
        String result = suggestInfoService.updateSuggest(suggestInfo);
        if (result=="fail") {
            return Result.resuleError("编辑失败");
        }
        return Result.resuleSuccess();
    }
    @ResponseBody
    @GetMapping("/getSuggest1")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getSuggest1( ) {
        List<Map<String, Object>> infoList = new ArrayList<>();
        List<SuggestInfo> permissionList = suggestInfoService.getSuggest1();
        for (SuggestInfo permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("id", permissionEntity.getId());
            permissionMap.put("phone", permissionEntity.getPhone());
            permissionMap.put("suggest", permissionEntity.getSuggest());
            permissionMap.put("createTime", permissionEntity.getCreateTime());
            permissionMap.put("status","待解决");
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }
    @ResponseBody
    @GetMapping("/getSuggest2")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getSuggest2( ) {

        List<Map<String, Object>> infoList = new ArrayList<>();
        List<SuggestInfo> permissionList = suggestInfoService.getSuggest2();
        for (SuggestInfo permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("id", permissionEntity.getId());
            permissionMap.put("phone", permissionEntity.getPhone());
            permissionMap.put("suggest", permissionEntity.getSuggest());
            permissionMap.put("updateTime", permissionEntity.getUpdateTime());
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }
}
