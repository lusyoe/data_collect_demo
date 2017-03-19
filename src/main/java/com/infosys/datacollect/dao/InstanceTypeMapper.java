package com.infosys.datacollect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.infosys.datacollect.config.BaseDao;
import com.infosys.datacollect.domain.InstanceType;

public interface InstanceTypeMapper extends BaseDao<InstanceType> {

    @Select("SELECT * FROM instance_type")
    List<InstanceType> selectAll();

    @Select("SELECT * FROM instance_type WHERE id=#{id}")
    InstanceType findOne(Integer id);
}