package com.infosys.datacollect.controller;

import static com.infosys.datacollect.utils.Constans.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.datacollect.dao.InstanceTypeMapper;
import com.infosys.datacollect.domain.Instance;
import com.infosys.datacollect.domain.InstanceType;
import com.infosys.datacollect.domain.InstanceView;
import com.infosys.datacollect.domain.Message;
import com.infosys.datacollect.exception.InstanceNotFoundException;
import com.infosys.datacollect.service.InstanceService;

@RestController
@RequestMapping("/v1/instance")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceTypeMapper instanceTypeMapper;

    @GetMapping(value = "/current")
    public Message showInstances() {
        
        return showInstances(1);
    }
    
    @GetMapping(value = "/current/{page}")
    public Message showInstances(@PathVariable Integer page) {
        
        Message message = new Message();
        
        List<InstanceView> all = instanceService.findAll(page);

        message.setData(all);
        message.setStatus(OK);
        message.setMsg("success");

        return message;
    }

    @GetMapping(value = "/{id}")
    public InstanceView showInstance(@PathVariable Integer id) throws Exception {

        InstanceView instance = instanceService.findOne(id);
        if (instance == null) {
            throw new InstanceNotFoundException(id);
        }

        return instance;
    }

    @PostMapping(value = "/add")
    public void addInstance(@RequestBody @Validated Instance record) {
        instanceService.addInstance(record);
    }

    @GetMapping("/types")
    public List<InstanceType> showInstanceTypeAll() {

        return instanceTypeMapper.selectAll();
    }

    @GetMapping("/type/{id}")
    public InstanceType showInstanceType(@PathVariable Integer id) {

        return instanceTypeMapper.findOne(id);
    }

}
