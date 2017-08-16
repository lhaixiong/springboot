package com.lhx.service;

import com.lhx.entity.LearnResource;
import com.lhx.tools.Page;

import java.util.Map;

public interface LearnResourceService {
    int add(LearnResource learnResouce);
    int update(LearnResource learnResouce);
    int deleteByIds(String ids);
    LearnResource queryLearnResourceById(Long learnResource);
    Page queryLearnResourceList(Map<String,Object> params);
}