package com.zxr.mygraduation.dao;

import com.zxr.mygraduation.entity.SuggestInfo;
import com.zxr.mygraduation.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SuggestInfoMapper interface
 * @author xueran.zhang
 * @date 2020/03/23
 */
@Repository
public interface SuggestInfoMapper {
    int insertSuggest(SuggestInfo suggestInfo);
    List<SuggestInfo> getSuggest2();
    List<SuggestInfo> getSuggest1();
    int updateSuggest(SuggestInfo suggestInfo);
}
