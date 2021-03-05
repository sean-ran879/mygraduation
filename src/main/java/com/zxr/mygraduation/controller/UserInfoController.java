package com.zxr.mygraduation.controller;

import com.zxr.mygraduation.dao.BankaccountFlowMapper;
import com.zxr.mygraduation.entity.*;

import com.zxr.mygraduation.service.IGuaranteeInfoService;

import com.zxr.mygraduation.service.IUserInfoService;

import com.zxr.mygraduation.service.impl.AccountInfoServiceImpl;
import com.zxr.mygraduation.service.impl.BankBindServiceImpl;
import com.zxr.mygraduation.service.impl.BankInfoServiceImpl;
import com.zxr.mygraduation.service.impl.GuaranteeInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(value = "/userInfo")
@Controller
/**
 * Demo class
 * @author keriezhang
 * @date 2016/10/31
 */
public class UserInfoController {
     String flag;
    @Autowired
    /**
     * Service的实体，用来调用实现方法
     */
    private IUserInfoService userInfoServiceImpl;
    @Autowired
    private GuaranteeInfoServiceImpl guaranteeInfoService;
    @Autowired
    private BankaccountFlowMapper bankaccountFlowMapper;
    @Autowired
    private BankBindServiceImpl bankBindService;
    @Autowired
    private BankInfoServiceImpl bankInfoService;
    @Autowired
    private AccountInfoServiceImpl accountInfoService;

    /**
     * 查询所有记录
     */
    @GetMapping("/getUserInfoAll")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> ListUserInfo() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<UserInfo> list = userInfoServiceImpl.getUserInfoList();
        modelMap.put("userInfoList", list);
        return modelMap;
    }
    @ApiOperation(value = "添加统计信息", notes = "添加统计信息")
    @PostMapping("/addUserInfo")
    /**
     *  添加记录
     */
    public Map<String, Object> addUserInfo(@RequestBody UserInfo userInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userInfoServiceImpl.addUserInfo(userInfo));
        return modelMap;
    }
    /**
     *  添加身份证照片
     */
    @GetMapping("/addPhoto")
    @ApiOperation(value = "上传用户身份证照片", notes = "上传用户身份证照片路径")
    public Map<String, Object> updatePhoto(@RequestBody UserInfo userInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userInfoServiceImpl.updatePhoto(userInfo));
        return modelMap;
    }
    @GetMapping("/updatePhoto")
    @ApiOperation(value = "更新用户现拍照片", notes = "更新用户现拍照片")
    public Map<String, Object> updateUserPhoto(@RequestBody UserInfo userInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userInfoServiceImpl.updateUserPhoto(userInfo));
        return modelMap;
    }
    @PostMapping("/updateInfo")
    @ApiOperation(value = "补充个人用户信息", notes = "补充用户信息")
    public Map<String, Object> updateInfo(@RequestBody UserInfo userInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userInfoServiceImpl.updateInfo(userInfo));
        return modelMap;
    }
    @ApiOperation(value = "获取用户表中的某条信息", notes = "根据用户id来获取详细信息")
    @GetMapping("/getByUserId")
    public   Map<String, Object> getByUserId(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        UserInfo userInfo = userInfoServiceImpl.getByUserId(userId);
        modelMap.put("phoneList", userInfo);
        return modelMap;
    }
    @ApiOperation(value = "获取担保人信息", notes = "根据用户id来获取详细信息")
    @GetMapping("/getByUserId1")
    public   Map<String, Object> getByUserId1(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        GuaranteeInfo guaranteeInfo=guaranteeInfoService.getByUserId(userId);
        modelMap.put("phoneList1",guaranteeInfo);
        return modelMap;
    }
    @ApiOperation(value = "获取担保人信息", notes = "根据用户id来获取详细信息")
    @GetMapping("/getByUserId3")
    public   Map<String, Object> getByUserId3(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        BankBind bankBind=bankBindService.getByUserId(userId);
        modelMap.put("phoneList3",bankBind);
        return modelMap;
    }
    @ApiOperation(value = "获取账户信息", notes = "根据用户id来获取详细信息")
    @GetMapping("/getByUserId4")
    public   Map<String, Object> getByUserId4(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        AccountInfo accountInfo=accountInfoService.selectByUserId(userId);
        modelMap.put("phoneList4",accountInfo);
        return modelMap;
    }
    @PostMapping("/updateBank")
    @ApiOperation(value = "更新银行卡信息信息", notes = "更新银行卡信息")
    public Map<String, Object> updateBank(@RequestBody BankBind bankBind) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bankBindService.updateBank(bankBind));
        return modelMap;
    }
    @GetMapping("/updateAccount")
    @ApiOperation(value = "更新银行卡信息信息", notes = "更新银行卡信息")
    public Map<String, Object> updateAccount(AccountInfo accountInfo) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", accountInfoService.updateAcount(accountInfo));
        return modelMap;
    }
    /**
     *  添加记录
     */
    @ApiOperation(value = "增加用户担保人信息", notes = "增加用户担保人")
    @PostMapping("/addGuarantee")
    public Map<String, Object> addGuarantee(@RequestBody GuaranteeInfo guaranteeInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", guaranteeInfoService.addGuarantee(guaranteeInfo));
        return modelMap;
    }
    @ApiOperation(value = "更新用户担保人信息", notes = "更新用户担保人")
    @PostMapping("/updateGuarantee")
    public Map<String, Object> updateGuarantee(@RequestBody GuaranteeInfo guaranteeInfo ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", guaranteeInfoService.updateGuarantee(guaranteeInfo));
        return modelMap;
    }
    @ApiOperation(value = "绑定银行卡", notes = "用户绑定银行卡")
    @PostMapping("/addBankBind")
    public Map<String, Object> addBankBind(@RequestBody BankBind bankBind ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bankBindService.addBankBind(bankBind));
        return modelMap;
    }
    @ApiOperation(value = "查看可绑定的银行卡", notes = "查看可绑定的银行卡")
    @PostMapping("/getBankInfo")
    public Map<String, Object> getBankInfo() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bankInfoService.getBankInfoList());
        return modelMap;
    }
    @ApiOperation(value = "查看可绑定的银行卡", notes = "查看可绑定的银行卡")
    @GetMapping("/getBankCount")
    public Map<String, Object> getBankCount(BankInfo bankInfo) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bankInfoService.getByBankName(bankInfo));
        return modelMap;
    }
    @ApiOperation(value = "查看用户的银行卡提现转入记录", notes = "查看用户的银行卡提现转入记录")
    @GetMapping("/getBankFlow")
    public Map<String, Object> getBankFlow(Integer userId) {
       Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",bankaccountFlowMapper.selectById(userId));
        return modelMap;
    }
    @ApiOperation(value = "添加银行卡转入提现记录", notes = "添加银行卡转入提现记录")
    @GetMapping("/addBankFlow")
    public Map<String, Object> addBankFlow(BankaccountFlow bankaccountFlow) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bankaccountFlowMapper.insertBankFlow(bankaccountFlow));
        return modelMap;
    }
}
