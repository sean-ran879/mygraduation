package com.zxr.mygraduation.controller;
import com.zxr.mygraduation.entity.TradingOrder;
import com.zxr.mygraduation.service.impl.TradingOrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/investOrder")
@Controller
/**
 * 借款人主页条件筛选接口
 * @author xueran.zhang
 * @date 2020/03/29
 */
public class InvestOrderController {
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
        List<TradingOrder> list =tradingOrderService.getOrderList1(map);
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




}
