package com.infosys.datacollect.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.infosys.datacollect.dao.InstanceMapper;
import com.infosys.datacollect.dao.InstanceViewMapper;
import com.infosys.datacollect.domain.Instance;
import com.infosys.datacollect.domain.InstanceView;

@Service
public class InstanceService {

    private static final Logger log = LoggerFactory.getLogger(InstanceService.class);

    private final int LIMIT = 5;
    
    @Autowired
    private InstanceViewMapper instanceViewMapper;
    
    @Autowired
    private InstanceMapper instanceMapper;

    public List<InstanceView> findAll(Integer page) {
        
        if (page == null || page == 1) {
            PageHelper.startPage(1, LIMIT);
        } else {
            PageHelper.offsetPage(page, LIMIT);
        }
        
        return instanceViewMapper.findAll();
    }

    @Transactional
    public void addInstance(Instance record) {
        instanceMapper.insert(record);
    }


    public InstanceView findOne(Integer id) {
        return instanceViewMapper.findOne(id);
    }
}
