package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.TradingOrder;
import com.zxr.mygraduation.entity.UseLoan;
import com.zxr.mygraduation.service.impl.TradingOrderServiceImpl;
import com.zxr.mygraduation.tool.Result;
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
@RequestMapping(value = "/LoanOrder")
@Controller
/**
 * 借款人主页条件筛选接口
 * @author xueran.zhang
 * @date 2020/03/29
 */
public class LoanOrderController {
    @Autowired
    private TradingOrderServiceImpl tradingOrderService;
    /**
     * 查询所有记录
     */
    @PostMapping("/getOrderList")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> getOrderList(@RequestBody Map<String, Object> map) {
        System.out.println("显示得到的参数"+map);
        Map<String, Object> modelMap = new HashMap<String, Object>();
       List<TradingOrder> list =tradingOrderService.getOrderList(map);
        modelMap.put("userInfoList", list);
        return modelMap;
    }
    @ApiOperation(value = "更新订单", notes = "更改订单")
    @GetMapping("/updateOrder")
    public Map<String, Object> updateOrder(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", tradingOrderService.updateOrder(tradingOrder));
        return modelMap;
    }
    /**
     *  添加记录
     */
    @ApiOperation(value = "添加统计信息", notes = "添加统计信息")
    @GetMapping("/addOrder")
    public Map<String, Object> addOrder(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",tradingOrderService.addOrder(tradingOrder));
        return modelMap;
    }
    @ApiOperation(value = "更新订单", notes = "更改订单")
    @GetMapping("/updateOrder1")
    public Map<String, Object> updateOrder1(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", tradingOrderService.updateOrder1(tradingOrder));
        return modelMap;
    }
    /**
     * 查询所有记录
     */
    @GetMapping("/getPreLoan")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> getPreLoan(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        TradingOrder list =tradingOrderService.getPreLoan(tradingOrder);
        modelMap.put("List", list);
        return modelMap;
    }
    @GetMapping("/getPreLoan1")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息统计列表")
    private Map<String, Object> getPreLoan1(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("接受到的参数为:"+tradingOrder);
        TradingOrder list =tradingOrderService.getPreLoan1(tradingOrder);
      System.out.println("是否有审核中的订单"+list);
        modelMap.put("List", list);
        return modelMap;
    }
    @GetMapping("/getTransOrder1")
    @ApiOperation(value = "获取借款用途表记录", notes = "获取用户借款用途统计列表")
    private Map<String, Object> getTransOrder1(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<TradingOrder> list = tradingOrderService.getTransOrder1(tradingOrder);
        System.out.println(list);
        modelMap.put("TradsOrder1", list);
        return modelMap;
    }

    @GetMapping("/getTransOrder2")
    @ApiOperation(value = "获取借款用途表记录", notes = "获取用户借款用途统计列表")
    private Map<String, Object> getTransOrder2(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<TradingOrder> list = tradingOrderService.getTransOrder2(tradingOrder);
        System.out.println("fffffffffffffffffff"+list);
        modelMap.put("TransOrder2", list);
        return modelMap;
    }
    @GetMapping("/getTransId")
    @ApiOperation(value = "根据交易单号获取交易记录", notes = "根据交易单号获取交易记录")
    private Map<String, Object> getTransId(TradingOrder tradingOrder) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        TradingOrder list = tradingOrderService.getTransId(tradingOrder);
        System.out.println(list);
        modelMap.put("transId", list);
        return modelMap;
    }

    @ResponseBody
    @GetMapping("/getOrderAll")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getOrderAll( ) {
        List<Map<String, Object>> infoList = new ArrayList<>();
        List<TradingOrder> permissionList = tradingOrderService.getOrderAll();
         for (TradingOrder permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("transflowId", permissionEntity.getTransflowId());
            permissionMap.put("useLoan", permissionEntity.getUseLoan());
            permissionMap.put("loanId", permissionEntity.getLoanId());
            permissionMap.put("investId", permissionEntity.getInvestId());
            permissionMap.put("allMoney", permissionEntity.getAllMoney());
            permissionMap.put("totalPeriod", permissionEntity.getTotalPeriod());
            permissionMap.put("rate", permissionEntity.getRate());
            permissionMap.put("transTime", permissionEntity.getTransTime());
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }
    @ResponseBody
    @GetMapping("/getOrderAll2")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getOrderAll2( ) {
        List<Map<String, Object>> infoList = new ArrayList<>();
        List<TradingOrder> permissionList = tradingOrderService.getOrderAll2();
        for (TradingOrder permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("transflowId", permissionEntity.getTransflowId());
            permissionMap.put("useLoan", permissionEntity.getUseLoan());
            permissionMap.put("loanId", permissionEntity.getLoanId());
            permissionMap.put("investId", permissionEntity.getInvestId());
            permissionMap.put("allMoney", permissionEntity.getAllMoney());
            permissionMap.put("totalPeriod", permissionEntity.getTotalPeriod());
            permissionMap.put("rate", permissionEntity.getRate());
            permissionMap.put("transTime", permissionEntity.getTransTime());
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }
    @ResponseBody
    @GetMapping("/getOrderAll0")
    @ApiOperation(value = "获取借款用途表记录管理员", notes = "获取用户借款用途统计列表")
    private TableResultResponse getOrderAll0( ) {
        List<Map<String, Object>> infoList = new ArrayList<>();
        List<TradingOrder> permissionList = tradingOrderService.getOrderAll0();
        for (TradingOrder permissionEntity : permissionList) {
            Map<String, Object> permissionMap = new HashMap<>(16);
            permissionMap.put("transflowId", permissionEntity.getTransflowId());
            permissionMap.put("useLoan", permissionEntity.getUseLoan());
            if(permissionEntity.getLoanId()==0){
                permissionMap.put("userId", permissionEntity.getLoanId());
                permissionMap.put("status","投资订单");
            }else if(permissionEntity.getInvestId()==0){
                permissionMap.put("userId", permissionEntity.getLoanId());
                permissionMap.put("status","借款订单");
            }
            permissionMap.put("investId", permissionEntity.getInvestId());
            permissionMap.put("allMoney", permissionEntity.getAllMoney());
            permissionMap.put("totalPeriod", permissionEntity.getTotalPeriod());
            permissionMap.put("rate", permissionEntity.getRate());
            permissionMap.put("transTime", permissionEntity.getTransTime());
            infoList.add(permissionMap);
        }
        System.out.println(Result.tableResule(0, infoList));
        return Result.tableResule(0, infoList);
    }
}
