package com.zxr.mygraduation.service.impl;

import com.zxr.mygraduation.dao.SuggestInfoMapper;
import com.zxr.mygraduation.dao.UserMapper;
import com.zxr.mygraduation.entity.SuggestInfo;
import com.zxr.mygraduation.service.ISuggestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuggestInfoServiceImpl implements ISuggestInfoService {
    @Autowired
    private SuggestInfoMapper suggestInfoMapper;
    @Override
    public List<SuggestInfo> getSuggest1() {
        return suggestInfoMapper.getSuggest1();
    }

    @Override
    public List<SuggestInfo> getSuggest2() {
        return suggestInfoMapper.getSuggest2();
    }

    @Override
    public boolean addSuggest(SuggestInfo suggestInfo) {
        try {
            int effectedNum = suggestInfoMapper.insertSuggest(suggestInfo);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("插入信息失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("插入信息失败：" + e.getMessage());
        }
    }

    @Override
    public String updateSuggest(SuggestInfo suggestInfo) {
        suggestInfo.setStatus(1);
        int result =suggestInfoMapper.updateSuggest(suggestInfo);
        if (result == 1) {
            return "success";
        }
        return "fail";
    }

}
