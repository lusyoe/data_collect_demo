package com.infosys.datacollect.exception;

public class InstanceNotFoundException extends RuntimeException {

   
    private static final long serialVersionUID = 9218497187842613747L;
    
    private int instanceId;

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public InstanceNotFoundException(int instanceId) {
        super("Instance [" + instanceId + "] not found!");
        this.instanceId = instanceId;
    }

    public InstanceNotFoundException() {
        
    }
}
