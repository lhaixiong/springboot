package com.lhx.dao.impl;

import com.lhx.dao.LearnResourceDao;
import com.lhx.entity.LearnResource;
import com.lhx.tools.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LearnResourceDaoImpl implements LearnResourceDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResource learnResource) {
        return jdbcTemplate.update("insert into learn_resource(author, title,url) values(?, ?, ?)",learnResource.getAuthor(),learnResource.getTitle(),learnResource.getUrl());
    }

    @Override
    public int update(LearnResource learnResource) {
        return jdbcTemplate.update("update learn_resource set author=?,title=?,url=? where id = ?",new Object[]{learnResource.getAuthor(),learnResource.getTitle(),learnResource.getUrl(),learnResource.getId()});
    }

    @Override
    public int deleteByIds(String ids){
        return jdbcTemplate.update("delete from learn_resource where id in("+ids+")");
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        List<LearnResource> list = jdbcTemplate.query("select * from learn_resource where id = ?", new Object[]{id}, new BeanPropertyRowMapper(LearnResource.class));
        if(null != list && list.size()>0){
            LearnResource learnResource = list.get(0);
            return learnResource;
        }else{
            return null;
        }
    }

    @Override
    public Page queryLearnResourceList(Map<String,Object> params) {
        StringBuffer sql =new StringBuffer();
        sql.append("select * from learn_resource where 1=1");
        if(!StringUtils.isBlank((String)params.get("author"))){
            sql.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if(!StringUtils.isBlank((String)params.get("title"))){
            sql.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()), jdbcTemplate);
        return page;
    }
}
