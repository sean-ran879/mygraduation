package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.TradingOrder;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * ITradingOrderService class
 * @author xueran.zhang
 * @date 2020/03/29
 */
@Service
public interface ITradingOrderService {
    /**
     *用户选择条件为金额排序和不限金额和期数
     * @param tradingOrder rule
     * @return List<TradingOrder>
     */
     List<TradingOrder> getMoneySort(TradingOrder tradingOrder);
    /**
     *更新记录
     * @param tradingOrder rule
     * @return String
     */
    String updateOrder(TradingOrder tradingOrder);
    String updateOrder1(TradingOrder tradingOrder);
    /**
     *添加记录
     * @param tradingOrder rule
     * @return String
     */
    boolean addOrder(TradingOrder tradingOrder);
    TradingOrder getPreLoan(TradingOrder tradingOrder);
    TradingOrder getPreLoan1(TradingOrder tradingOrder);
    List<TradingOrder> getOrderAll();
    List<TradingOrder> getOrderAll2();
    List<TradingOrder> getOrderAll0();
}