package com.zxr.mygraduation.dao;
import com.zxr.mygraduation.entity.UserInfo;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * UserInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/09
 */
@Repository
public interface UserInfoMapper {
    /**
     *fetch data by rule id
     * 插入记录(身份证信息)
     * @param userInfo rule
     * @return Result<UserInfo>
     */
    int insertUserInfo(UserInfo userInfo);
    /**
     *fetch data by rule id
     * 插入记录(添加身份证照片)
     * @param userInfo rule
     * @return Result<UserInfo>
     */
    int updatePhoto(UserInfo userInfo);
    int addPhoto(UserInfo userInfo);
    /**
     *fetch data by rule id
     * 插入记录(更新用户照片)
     * @param userInfo rule
     * @return Result<UserInfo>
     */
    int updateUserPhoto(UserInfo userInfo);
    /**
     *fetch data by rule id
     * 插入更新记录(只针对部分字段更新)
     * @param userInfo rule
     * @return Result<UserInfo>
     */
    int updateInfo(UserInfo userInfo);
    /**
     * 显示所有记录
     * @param
     * @return
     */
    List<UserInfo> selectUserInfo();
    /**
     * 根据ID查记录
     * @param userId rule id
     * @return userInfo
     */
    UserInfo selectByUserId(Integer userId);


}
