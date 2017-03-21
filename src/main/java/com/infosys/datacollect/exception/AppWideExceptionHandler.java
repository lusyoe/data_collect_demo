package com.infosys.datacollect.exception;

import static com.infosys.datacollect.utils.Constans.FAILURE;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.infosys.datacollect.domain.Message;

@ControllerAdvice
public class AppWideExceptionHandler {
    
    @ExceptionHandler(InstanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public InstanceNotFoundException instanceNotFound(InstanceNotFoundException e) {
        int instanceId = e.getInstanceId();
        return new InstanceNotFoundException(instanceId);
    }
    
    @ExceptionHandler(InstanceQueryException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Message communicationsException(InstanceQueryException e) {
        Message msg = new Message();
        msg.setData(null);
        msg.setStatus(FAILURE);
        msg.setMsg(e.getMessage());
        return msg;
    }
}
