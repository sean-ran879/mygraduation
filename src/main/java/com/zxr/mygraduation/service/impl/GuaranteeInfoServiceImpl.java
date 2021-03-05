package com.zxr.mygraduation.service.impl;
import com.zxr.mygraduation.dao.GuaranteeInfoMapper;
import com.zxr.mygraduation.entity.GuaranteeInfo;
import com.zxr.mygraduation.service.IGuaranteeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * GuaranteeInfoServiceImpl class
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Service
public class GuaranteeInfoServiceImpl implements IGuaranteeInfoService {
    @Autowired
    private GuaranteeInfoMapper guaranteeInfoMapper ;
    @Transactional(rollbackFor = Exception.class)
    @Override
    /**
     * 添加数据
     */
    public boolean addGuarantee(GuaranteeInfo guaranteeInfo) {
            if (guaranteeInfo.getGuaranteeId() != null && !"".equals(guaranteeInfo.getGuaranteeId() )) {
                try {
                    System.out.println("担保人信息"+guaranteeInfo);
                    int effectedNum = guaranteeInfoMapper.insertGuarantee(guaranteeInfo);
                    if (effectedNum > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入信息失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入信息失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("信息不能为空");
            }
    }
    @Override
    /**
     *根据userId查询记录
     */
    public GuaranteeInfo getByUserId(Integer userId) {
        GuaranteeInfo userInfo = guaranteeInfoMapper.selectByUserId(userId);
        return userInfo;
    }
    /**
     * 更新记录
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateGuarantee(GuaranteeInfo guaranteeInfo) {
        int result = guaranteeInfoMapper.updateGuarantee(guaranteeInfo);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }
}
