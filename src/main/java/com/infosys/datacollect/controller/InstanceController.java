package com.infosys.datacollect.controller;

import com.alibaba.fastjson.JSON;
import com.infosys.datacollect.dao.InstanceTypeMapper;
import com.infosys.datacollect.domain.Instance;
import com.infosys.datacollect.domain.InstanceType;
import com.infosys.datacollect.domain.InstanceView;
import com.infosys.datacollect.domain.Message;
import com.infosys.datacollect.exception.InstanceNotFoundException;
import com.infosys.datacollect.exception.InstanceQueryException;
import com.infosys.datacollect.service.InstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.infosys.datacollect.utils.Constans.OK;

@RestController
@RequestMapping("/v1/instance")
@Api(tags = "resource manager", description = "资源管理模块接口v1")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceTypeMapper instanceTypeMapper;

    @GetMapping(value = "/current")
    @ApiOperation(value = "获取默认资源实例列表", notes = "默认只显示第一页")
    public Message showInstances(HttpServletResponse response) {

        return showInstances(1, "");
    }

    @GetMapping(value = "/current/{page}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取资源实例列表", notes = "需要提供页码", produces = "application/json")
    @ApiImplicitParams(value =  {
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "query", value = "请求参数", paramType = "query")
    })
    public Message showInstances(@PathVariable Integer page, 
            @RequestParam(value = "query") String instanceViewjson) {

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
