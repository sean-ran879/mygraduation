package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.AdminMapper;
import com.zxr.mygraduation.dao.TradingOrderMapper;
import com.zxr.mygraduation.entity.Admin;
import com.zxr.mygraduation.model.NumVO;
import com.zxr.mygraduation.service.IAdminService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminServiceImpl class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public class AdminServiceImpl  implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TradingOrderMapper tradingOrderMapper;
    @Override
    /**
     *根据userPhone查询记录
     */
    public Admin getByUserPhone(String root) {
        Admin user = adminMapper.selectByUserPhone(root);
        return user;
    }
    @Override
    public String loginRoot(String root,String password){
        String flag;
        Admin user= adminMapper.selectByUserPhone(root);
        String pwd=user.getPassword();
        String root1=user.getRoot();
        if(password.equals(pwd)&& root1.equals(root)){
            flag="success";
        }else {
            flag="fails";
        }

        return flag;
    }

    @Override
    public NumVO loginNum() {
        Integer loanNum,investNum,orderNum;
loanNum=tradingOrderMapper.loanNum();
investNum=tradingOrderMapper.investNum();
orderNum=tradingOrderMapper.orderNum();

NumVO numVO=new NumVO();
numVO.setInvestNum(investNum);
numVO.setLoanNum(loanNum);
numVO.setOrderNum(orderNum);
        return numVO;
    }
}
