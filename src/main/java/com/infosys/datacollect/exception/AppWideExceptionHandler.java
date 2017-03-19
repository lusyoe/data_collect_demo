package com.infosys.datacollect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppWideExceptionHandler {
    
    @ExceptionHandler(InstanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public InstanceNotFoundException instanceNotFound(InstanceNotFoundException e) {
        int instanceId = e.getInstanceId();
        return new InstanceNotFoundException(instanceId);
    }
    
    
}
