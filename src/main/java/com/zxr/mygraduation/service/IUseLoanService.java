package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.UseLoan;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IUseLoanService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IUseLoanService {
    /**
     * fetch data by rule id
     * @return Result<User>
     * 查询所有借款用途
     */
    List<UseLoan> getUseLoanList();
    /**
     * fetch data by rule id
     * @param useLoan rule
     * 添加客户注册信息
     * @return Result<UseLoan>
     */
    boolean addUseLoan(UseLoan useLoan );
    /**
     * 用户修改借款用途名称等
     * @param useLoan rule
     * 更新表记录
     * @return Result<UseLoan>
     */
    String updateUseLoan(UseLoan useLoan);
    /**
     * 根据银行卡名称删除记录
     * @param useLoan rule
     * @return
     */
    boolean deleteUseLoan(String useLoan);


}
