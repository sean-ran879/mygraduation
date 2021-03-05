package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.TradingOrderMapper;
import com.zxr.mygraduation.entity.TradingOrder;
import com.zxr.mygraduation.service.ITradingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.server.InactiveGroupException;

import java.util.*;

/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public class TradingOrderServiceImpl implements ITradingOrderService {
    @Autowired
    private TradingOrderMapper tradingOrderMapper;
    /**
     *根据userPhone查询记录
     */
    public List<TradingOrder> getOrderList(Map<String, Object> map) {
        //把参数params单独取出并赋值给map1
        Object ob = map.get("params");
        Map<String, Object> map1= (Map<String, Object>) ob;
        TradingOrder tradingOrder=new TradingOrder();
        //把参数checkedValue单独取出并赋值给list
        Object ob1=map.get("checkedValue");
        List<Object> list= (List<Object>) ob1;
        //发布时间
        String time="";
        //按金额升序还是降序
        //借款期数
        Integer totalPeriod;
        //最大金额值
        Double allMoney;
        //代表用户选择的是金额排序和筛选
        if(map1.values().size()!=3 && map1.values().size()!=0){
            //金额升序，金额和期数不限
            if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") && ((int)list.get(1))==-1) {
                List<TradingOrder> list1=getMoneySort(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额降序，金额和期数不限
            else if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") && ((int)list.get(1))==1){
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort1(tradingOrder);
                System.out.println(list1);
                return list1;

            }
            //金额升序，金额和期数限制
           else if(((int)list.get(1))==-1 && !map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()) );
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort2(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额降序，金额和期数限制
           else if(((int)list.get(1))==1 && !map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort3(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额升序，金额限制，期数不限
            else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") &&((int)list.get(1))==-1){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort4(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额降序，金额限制，期数不限
            else if(!map1.get("LoanMoney").equals("no")&&
                    map1.get("LoanNum").equals("no") &&((int)list.get(1))==1){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort5(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额升序，金额不限，期数限制
            else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")
                    &&((int)list.get(1))==-1){
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort6(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //金额降序，金额不限，期数限制
            else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")
                    &&((int)list.get(1))==1){
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getMoneySort7(tradingOrder);
                System.out.println(list1);
                return list1;
            }
        }


        else if(map1.values().size()==3){
            List<TradingOrder> list1;
            if(map1.get("Time").equals("SevenDay")){
                //两个都不限
                if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    list1=tradingOrderMapper.getTime1(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额限制期数不限
                else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    list1=tradingOrderMapper.getTime3(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额不限期数限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTime5(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //两个都限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTime7(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
            }
            else{
                 //两个都不限
                if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")) {
                    list1=tradingOrderMapper.getTime2(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额限制期数不限
                else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    list1=tradingOrderMapper.getTime4(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额不限期数限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTime6(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //两个都限制
                else if(!map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTime8(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
            }

}
else{
            List<TradingOrder> list1=tradingOrderMapper.getTime1(tradingOrder);
            System.out.println(list1);
            return list1;
        }
        return null;
    }
    /**
     *用户选择条件为金额排序和不限金额和期数
     */
    @Override
    public List<TradingOrder> getMoneySort(TradingOrder tradingOrder){
       List<TradingOrder> list= tradingOrderMapper.getMoneySort(tradingOrder);
       return list;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateOrder1(TradingOrder tradingOrder) {
        int result =tradingOrderMapper.updateOrder1(tradingOrder);
        if (result != 0) {
            return "success";
        }
        return "fail";
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateOrder(TradingOrder tradingOrder) {
        int result =tradingOrderMapper.updateOrder(tradingOrder);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addOrder(TradingOrder tradingOrder) {
        int effectedNum = tradingOrderMapper.insertOrder(tradingOrder);
        if (effectedNum > 0) {
            return true;
        } else {
            throw new RuntimeException("插入信息失败！");
        }
    }
    @Override
    public TradingOrder getPreLoan1(TradingOrder tradingOrder){
        TradingOrder list= tradingOrderMapper.getPreLoan1(tradingOrder);
        return list;
    }

    @Override
    public List<TradingOrder> getOrderAll() {
        return tradingOrderMapper.getOrderAll();
    }

    @Override
    public List<TradingOrder> getOrderAll2() {
        return tradingOrderMapper.getOrderAll2();
    }

    @Override
    public List<TradingOrder> getOrderAll0() {
        return tradingOrderMapper.getOrderAll0();
    }

    @Override
    public TradingOrder getPreLoan(TradingOrder tradingOrder){
       TradingOrder list= tradingOrderMapper.getPreLoan(tradingOrder);
        return list;
    }
    public List<TradingOrder> getOrderList1(Map<String, Object> map) {
        //把参数params单独取出并赋值给map1
        Object ob = map.get("params");
        Map<String, Object> map1= (Map<String, Object>) ob;
        TradingOrder tradingOrder=new TradingOrder();
        //把参数checkedValue单独取出并赋值给list
        Object ob1=map.get("checkedValue");
        List<Object> list= (List<Object>) ob1;
        //发布时间
        String time="";
        //按金额升序还是降序
        //借款期数
        Integer totalPeriod;
        //最大金额值
//        Double allMoney;
        Integer creditValue;
        //代表用户选择的是信用值排序和筛选
        if(map1.values().size()!=3 && map1.values().size()!=0){
            //信用值升序，金额和期数不限
            if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") && ((int)list.get(1))==-1) {
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值降序，金额和期数不限
            else if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") && ((int)list.get(1))==1){
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort1(tradingOrder);
                System.out.println(list1);
                return list1;

            }
            //信用值升序，金额和期数限制
            else if(((int)list.get(1))==-1 && !map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()) );
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort2(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值降序，金额和期数限制
            else if(((int)list.get(1))==1 && !map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort3(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值升序，金额限制，期数不限
            else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no") &&((int)list.get(1))==-1){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort4(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值降序，金额限制，期数不限
            else if(!map1.get("LoanMoney").equals("no")&&
                    map1.get("LoanNum").equals("no") &&((int)list.get(1))==1){
                tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort5(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值升序，金额不限，期数限制
            else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")
                    &&((int)list.get(1))==-1){
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort6(tradingOrder);
                System.out.println(list1);
                return list1;
            }
            //信用值降序，金额不限，期数限制
            else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")
                    &&((int)list.get(1))==1){
                tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                List<TradingOrder> list1=tradingOrderMapper.getCreditSort7(tradingOrder);
                System.out.println(list1);
                return list1;
            }
        }


        else if(map1.values().size()==3){
            List<TradingOrder> list1;
            if(map1.get("Time").equals("SevenDay")){
                //两个都不限
                if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    list1=tradingOrderMapper.getTimeCredit1(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额限制期数不限
                else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    list1=tradingOrderMapper.getTimeCredit3(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额不限期数限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTimeCredit5(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //两个都限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTimeCredit7(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
            }
            else{
                //两个都不限
                if(map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")) {
                    list1=tradingOrderMapper.getTimeCredit2(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额限制期数不限
                else if(!map1.get("LoanMoney").equals("no")&& map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    list1=tradingOrderMapper.getTimeCredit4(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //金额不限期数限制
                else if(map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTimeCredit6(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
                //两个都限制
                else if(!map1.get("LoanMoney").equals("no")&& !map1.get("LoanNum").equals("no")){
                    tradingOrder.setAllMoney(Double.parseDouble(map1.get("LoanMoney").toString()));
                    tradingOrder.setTotalPeriod(Integer.parseInt( map1.get("LoanNum").toString()));
                    list1=tradingOrderMapper.getTimeCredit8(tradingOrder);
                    System.out.println(list1);
                    return list1;
                }
            }

        }
        else{
            List<TradingOrder> list1=tradingOrderMapper.getTimeCredit1(tradingOrder);
            System.out.println(list1);
            return list1;
        }
        return null;
    }
    public List<TradingOrder> getTransOrder1(TradingOrder tradingOrder){
        List<TradingOrder> list1= tradingOrderMapper.getTransOrder1(tradingOrder);
        return list1;
     }
    public List<TradingOrder> getTransOrder2(TradingOrder tradingOrder){
        List<TradingOrder> list1= tradingOrderMapper.getTransOrder2(tradingOrder);
        return list1;
    }
    public TradingOrder getTransId(TradingOrder tradingOrder){
      TradingOrder list1= tradingOrderMapper.getTransId(tradingOrder);
        return list1;
    }
}
