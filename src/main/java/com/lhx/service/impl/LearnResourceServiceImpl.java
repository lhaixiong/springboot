package com.lhx.service.impl;

import com.lhx.dao.LearnResourceDao;
import com.lhx.entity.LearnResource;
import com.lhx.service.LearnResourceService;
import com.lhx.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LearnResourceServiceImpl implements LearnResourceService{
    @Autowired
    LearnResourceDao dao;
    @Override
    public int add(LearnResource learnResource) {
        return this.dao.add(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return this.dao.update(learnResource);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.dao.deleteByIds(ids);
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        return this.dao.queryLearnResourceById(id);
    }

    @Override
    public Page queryLearnResourceList(Map<String,Object> params) {
        return this.dao.queryLearnResourceList(params);
    }
}
