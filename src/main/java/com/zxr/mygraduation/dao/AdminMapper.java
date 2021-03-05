package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * AdminMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface AdminMapper {
    /**
     * 根据手机号得到记录
     * @param root rule id
     * @return userInfo
     */
    Admin selectByUserPhone(String root);

}
