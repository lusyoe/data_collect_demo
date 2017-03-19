package com.infosys.datacollect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.infosys.datacollect.config.BaseDao;
import com.infosys.datacollect.domain.InstanceCategory;

public interface InstanceCategoryMapper extends BaseDao<InstanceCategory> {
 
    @Select("SELECT * FROM instance_category")
    List<InstanceCategory> selectAll();
}