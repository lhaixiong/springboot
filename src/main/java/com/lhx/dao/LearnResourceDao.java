package com.lhx.dao;

import com.lhx.entity.LearnResource;
import com.lhx.tools.Page;

import java.util.Map;

public interface LearnResourceDao {
    int add(LearnResource learnResouce);
    int update(LearnResource learnResouce);
    int deleteByIds(String ids);
    LearnResource queryLearnResourceById(Long id);
    Page queryLearnResourceList(Map<String,Object> params);
}
