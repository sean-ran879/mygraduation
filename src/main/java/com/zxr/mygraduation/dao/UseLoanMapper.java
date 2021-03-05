package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.UseLoan;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * UseLoanMapper interface
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Repository
public interface UseLoanMapper {
    /**
     * fetch data by rule id
     * 插入记录
     * @param useLoan rule
     * @return Result<useloan>
     */
    int insertUseLoan(UseLoan useLoan);
    /**
     * 显示所有借款用途
     * @param
     * @return
     */
    List<UseLoan> selectUseLoan();
    /**
     * fetch data by rule id
     * 更新记录（更新借款用途名称）
     * @param useLoan rule
     * @return Result<UseLoan>
     */
    int updateUseLoan(UseLoan useLoan);
    /**
     * 根据借款用途名称删除记录
     * @param useLoan rule
     * @return
     */
    int deleteUseLoan(String useLoan);


}