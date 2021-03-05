package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.TradingOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TradingOrderMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface TradingOrderMapper {
    /**
     * 按条件显示记录
      *用户选择条件为金额排序和不限金额和期数
     * @param tradingOrder
     * @return List<TradingOrder>
     */
    List<TradingOrder> getMoneySort(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort1(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort2(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort3(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort4(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort5(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort6(TradingOrder tradingOrder);
    List<TradingOrder> getMoneySort7(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort1(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort2(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort3(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort4(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort5(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort6(TradingOrder tradingOrder);
    List<TradingOrder> getCreditSort7(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit1(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit2(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit3(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit4(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit5(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit6(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit7(TradingOrder tradingOrder);
    List<TradingOrder> getTimeCredit8(TradingOrder tradingOrder);
    List<TradingOrder> getTime1(TradingOrder tradingOrder);
    List<TradingOrder> getTime2(TradingOrder tradingOrder);
    List<TradingOrder> getTime3(TradingOrder tradingOrder);
    List<TradingOrder> getTime4(TradingOrder tradingOrder);
    List<TradingOrder> getTime5(TradingOrder tradingOrder);
    List<TradingOrder> getTime6(TradingOrder tradingOrder);
    List<TradingOrder> getTime7(TradingOrder tradingOrder);
    List<TradingOrder> getTime8(TradingOrder tradingOrder);
   int updateOrder(TradingOrder tradingOrder);
    int updateOrder1(TradingOrder tradingOrder);
   int insertOrder(TradingOrder tradingOrder);
   TradingOrder getPreLoan(TradingOrder tradingOrder);
    TradingOrder getPreLoan1(TradingOrder tradingOrder);
    List<TradingOrder> getTransOrder1(TradingOrder tradingOrder);
    List<TradingOrder> getTransOrder2(TradingOrder tradingOrder);
    TradingOrder getTransId(TradingOrder tradingOrder);
    Integer loanNum();
    Integer investNum();
    Integer orderNum();
    List<TradingOrder> getOrderAll();
    List<TradingOrder> getOrderAll2();
    List<TradingOrder> getOrderAll0();
}
