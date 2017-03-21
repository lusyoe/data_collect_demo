package com.infosys.datacollect.config;

import java.util.List;

import com.infosys.datacollect.domain.InstanceView;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {

    public List<T> findAll(InstanceView record);

    public T findOne(Integer id);
}
