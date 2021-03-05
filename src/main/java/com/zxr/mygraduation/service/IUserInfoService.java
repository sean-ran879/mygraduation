package com.zxr.mygraduation.service;
import com.zxr.mygraduation.entity.UserInfo;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * IUserInfoService class
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Service
public interface IUserInfoService {
    /**
     * fetch data by rule id
     * @return Result<DaySummary>
     * 查询所有信息
     */
    List<UserInfo> getUserInfoList();
    /**
     * fetch data by rule id
     * @param userInfo rule
     * 添加客户身份证信息
     * @return Result<UserInfo>
     */
    boolean addUserInfo(UserInfo userInfo);
    /**
     * fetch data by rule id
     * @param userInfo rule
     * 添加客户身份证照片信息
     * @return Result<UserInfo>
     */
    String updatePhoto(UserInfo userInfo);
    /**
     * fetch data by rule id
     * @param userId rule
     * 根据user_id查找记录
     * @return UserInfo
     */
    UserInfo getByUserId(Integer userId);
    /**
     * 更新用户当前个人照片
     * @param userInfo rule
     * @return Result<User>
     */
    boolean addPhoto(UserInfo userInfo);
    String updateUserPhoto(UserInfo userInfo);
    /**
     * 更新用户当前其他个人信息
     * @param userInfo rule
     * @return Result<User>
     */
    String updateInfo(UserInfo userInfo);


}
