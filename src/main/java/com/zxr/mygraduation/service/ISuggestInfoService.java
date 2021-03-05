package com.zxr.mygraduation.service;

import com.zxr.mygraduation.entity.SuggestInfo;
import com.zxr.mygraduation.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISuggestInfoService {
    List<SuggestInfo> getSuggest1();
    List<SuggestInfo> getSuggest2();
    boolean addSuggest(SuggestInfo suggestInfo);
    String updateSuggest(SuggestInfo suggestInfo);
}
