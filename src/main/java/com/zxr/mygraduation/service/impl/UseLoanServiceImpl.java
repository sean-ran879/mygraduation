package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.UseLoanMapper;
import com.zxr.mygraduation.entity.UseLoan;
import com.zxr.mygraduation.service.IUseLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
/**
 * UserService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
public class UseLoanServiceImpl implements IUseLoanService {
    @Autowired
    private UseLoanMapper useLoanMapper;


    @Override
    /**
     *获取全部记录
     */
    public List<UseLoan> getUseLoanList() {
        return useLoanMapper.selectUseLoan();
    }
    /**
     * 添加数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUseLoan(UseLoan useLoan) {
        try {
            int effectedNum = useLoanMapper.insertUseLoan(useLoan);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("插入信息失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("插入信息失败：" + e.getMessage());
        }
    }
    /**
     * 修改借款用途名称
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateUseLoan(UseLoan useLoan) {
        int result = useLoanMapper.updateUseLoan(useLoan);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }
    /**
     * 根据借款用途名称删除记录
     */
    @Override
    public boolean deleteUseLoan(String userLoan) {
        if (userLoan != "") {
            try {
                int effectedNum = useLoanMapper.deleteUseLoan(userLoan);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("信息不能为空");
        }
    }
}
