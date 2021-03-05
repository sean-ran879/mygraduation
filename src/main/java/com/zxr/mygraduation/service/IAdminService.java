package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.Admin;
import com.zxr.mygraduation.model.NumVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

/**
 * IAccountFlowService class
 * @author xueran.zhang
 * @date 2020/03/19
 */
@Service
public interface IAdminService {
    /**
     * fetch data by rule id
     * @param root rule
     * 根据手机号查找记录
     * @return User
     */
    Admin getByUserPhone(String root);
    String loginRoot(String root,String password);
    NumVO loginNum();


}
