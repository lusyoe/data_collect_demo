package com.infosys.datacollect.controller;

import static com.infosys.datacollect.utils.Constans.OK;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.infosys.datacollect.dao.InstanceTypeMapper;
import com.infosys.datacollect.domain.Instance;
import com.infosys.datacollect.domain.InstanceType;
import com.infosys.datacollect.domain.InstanceView;
import com.infosys.datacollect.domain.Message;
import com.infosys.datacollect.exception.InstanceNotFoundException;
import com.infosys.datacollect.exception.InstanceQueryException;
import com.infosys.datacollect.service.InstanceService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/instance")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceTypeMapper instanceTypeMapper;

    @GetMapping(value = "/current")
    @ApiOperation(value = "获取默认资源实例列表", notes = "默认只显示第一页")
    public Message showInstances(HttpServletResponse response) {

        return showInstances(1, "", response);
    }

    @GetMapping(value = "/current/{page}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取资源实例列表", notes = "需要提供页码")
    @ApiImplicitParams(value =  {
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "query", value = "请求参数", required = false),
    })
    public Message showInstances(@PathVariable Integer page, 
            @RequestParam(value = "query") String instanceViewjson,
            HttpServletResponse response) {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        
        Message message = new Message();
        InstanceView record = JSON.parseObject(instanceViewjson, InstanceView.class);

        try {
            List<InstanceView> all = instanceService.findAll(page, record);

            message.setData(all);
            message.setStatus(OK);
            message.setMsg("success");
            
        } catch (Exception e) {
            throw new InstanceQueryException(e);
        }

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
