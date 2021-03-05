package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.*;
import com.zxr.mygraduation.service.IUserCodeService;
import com.zxr.mygraduation.service.IUserService;
import com.zxr.mygraduation.service.impl.UserCreditServiceImpl;
import com.zxr.mygraduation.service.impl.UserInfoServiceImpl;
import com.zxr.mygraduation.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.server.InactiveGroupException;

import java.util.*;
@RestController
@RequestMapping(value = "/user")
@Controller
/**
 * Demo class
 * @author keriezhang
 * @date 2016/10/31
 */
public class UserController {
    String flag;
    @Autowired
    /**
     * Service的实体，用来调用实现方法
     */
    private UserServiceImpl userService;
    @Autowired
    private UserCreditServiceImpl userCreditService;
    @Autowired
    private IUserCodeService userCodeServiceImpl;
    @Autowired
   private  UserInfoServiceImpl userInfoService;
    /**
     * 查询所有记录
     */
    @GetMapping("/getUserAll")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> ListUser() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> list = userService.getUserList();
        modelMap.put("userList", list);
        return modelMap;
    }
    @GetMapping("/getVerifyCode")
    @ApiOperation(value = "获取短信验证码", notes = "获取后台生成的6位随机数字")
    private Map<String, Object> getVerifyCode(String userPhone) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("手机号收到："+userPhone);
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        System.out.println("验证码："+verifyCode);
        UserCode userCode=new UserCode();
        userCode.setUserPhone(userPhone);
        userCode.setUserCode(verifyCode);
        UserCode uc=userCodeServiceImpl.getByUserPhone(userPhone);
        if(uc!=null) {
            userCodeServiceImpl.deleteUserCode(userPhone);
        }
        userCodeServiceImpl.addUserCode(userCode);
        modelMap.put("verifyCode", verifyCode);
        return modelMap;
    }
    @GetMapping("/isVerifyCode")
    @ApiOperation(value = "获取验证结果", notes = "获取后台生成的6位随机数字与前端输入的比对")
    private Map<String, Object> isVerifyCode(String userPhone,String userCode) {
        Calendar dateOne=Calendar.getInstance();
        Calendar dateTwo=Calendar.getInstance();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("验证 ："+userPhone);
        System.out.println("验证 ："+userCode);
        UserCode userCode1=userCodeServiceImpl.getByUserPhone(userPhone);
        System.out.println("查询表!!!!!!!!!!!!");
        if(userCode1!=null){
            System.out.println("不为空!!!!!!!!!!!!");
            String code1=userCode1.getUserCode();
            dateOne.setTime(new Date());
            System.out.println("表中时间："+userCode1.getCreateTime());
            System.out.println("现在的时间："+new Date());
            dateTwo.setTime(userCode1.getCreateTime());
            long timeOne=dateOne.getTimeInMillis();
            long timeTwo=dateTwo.getTimeInMillis();
            System.out.println("表中时间1："+timeOne);
            System.out.println("现在的时间1："+timeTwo);
            long minute=(timeOne-timeTwo)/(1000*60);
            if(code1!=null && code1==userCode1.getUserCode() && minute<=5){
                flag="1";
            }
            else{
                userCodeServiceImpl.deleteUserCode(userPhone);
                flag="0";
            }
        }
        modelMap.put("flag", flag);
        return modelMap;
    }
    @ApiOperation(value = "添加统计信息", notes = "添加统计信息")
    @GetMapping("/addUserCredit")
    public Map<String, Object> addUserCredit(String userPhone) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(userPhone.length()<=10){
            modelMap.put("success", 0);
        }else{
            System.out.println("传来的第一层参数"+userPhone);
            User user=userService.getByUserPhone(userPhone);
            System.out.println("传来的第一层参数"+user);
            UserCredit userCredit=new UserCredit();
            userCredit.setUserId(user.getUserId());
            UserInfo userInfo=new UserInfo();
            userInfo.setUserId(user.getUserId());
            BankBind bankBind=new BankBind();
            bankBind.setUserId(user.getUserId());
            userInfoService.addPhoto(userInfo);
            System.out.println("数出插入的对象啊信息"+userCredit);
            modelMap.put("success", userCreditService.addUserCredit(userCredit));
        }


        return modelMap;
    }
    @ApiOperation(value = "添加统计信息", notes = "添加统计信息")
    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody User user ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addUser(user));
        return modelMap;
    }
    @ApiOperation(value = "获取用户表中的某条信息", notes = "根据手机号来获取详细信息")
    @GetMapping("/getByUserPhone")
    public   Map<String, Object> getByUserPhone(String userPhone) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getByUserPhone(userPhone);
        modelMap.put("phoneList", user);
        return modelMap;
    }
    @GetMapping("/deleteUserCode")
    @ApiOperation(value = "删除短信表中记录", notes = "删除已经注册的电话")
    private Map<String, Object> deleteUserCode(String userPhone) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userCodeServiceImpl.deleteUserCode(userPhone));
        return modelMap;
    }
    @GetMapping("/loginUser")
    @ApiOperation(value = "登录验证", notes = "登录验证")
    private Map<String, Object> loginUser(String userPhone,String passWord) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("login", userService.loginUser(userPhone,passWord));
        return modelMap;
    }
    @GetMapping("/userCredit")
    @ApiOperation(value = "传入手机号", notes = "获取用户信用额度")
    private Map<String, Object> userCredit(String userPhone) {
        User user=userService.getByUserPhone(userPhone);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("userCredit", userCreditService.getByUserId(user.getUserId()));
        return modelMap;
    }
    @ApiOperation(value = "更新交易密码", notes = "设置交易密码")
    @GetMapping("/updateTransPw")
    public Map<String, Object> updateTransPw(User user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.updateUser(user));
        return modelMap;
    }
    @ApiOperation(value = "更新登录密码", notes = "更新登录密码")
    @GetMapping("/updatePassWord")
    public Map<String, Object> updatePassWord(User user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.updateUser(user));
        return modelMap;
    }
    @ApiOperation(value = "更新交易密码", notes = "更新交易密码")
    @GetMapping("/updateTransPw1")
    public Map<String, Object> updateTransPw1(String transPw,String newPw1, String name, Integer userId,String cardId) {
        User user=new User();
        //根据id得到userInfo中的姓名做比较
        user.setUserId(userId);
        user.setTransPw(newPw1);
        System.out.println(newPw1);
        UserInfo userInfo=new UserInfo();
        userInfo= userInfoService.getByUserId(userId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user1=userService.selectById(userId);
        String getName=userInfo.getUserName();
        String IdCard=userInfo.getIdCard();
        String transPw1=user1.getTransPw();
        if(!transPw1.equals(transPw)){
            modelMap.put("success", "原交易密码输入错误！");
        }
        else  if(!getName.equals(name)){
            modelMap.put("success", "姓名输入错误！");
        } else  if(!IdCard.equals(cardId)){
            modelMap.put("success", "身份证号输入错误！");
        }else{
            System.out.println("输出"+user);
            modelMap.put("success", userService.updateUser(user));
        }
        return modelMap;
    }
    @ApiOperation(value = "更新手机号", notes = "更新手机号")
    @GetMapping("/updatePhone")
    public Map<String, Object> updatePhone(String phone, String name, Integer userId) {
        User user=new User();
        //根据id得到userInfo中的姓名做比较
        UserInfo userInfo=new UserInfo();
        userInfo= userInfoService.getByUserId(userId);
        String getName=userInfo.getUserName();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        user.setUserPhone(phone);
        user.setUserId(userId);
        if(getName.equals(name)){
            modelMap.put("success", userService.updateUser(user));
        }else{
            modelMap.put("success", "姓名错误！");
        }

        return modelMap;
    }
    @ApiOperation(value = "根据用户id查询记录", notes = "根据用户id查询记录")
    @GetMapping("/getById")
    public Map<String, Object> getById(User user) {
        Integer userId=user.getUserId();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.selectById(userId));
        return modelMap;
    }
}
