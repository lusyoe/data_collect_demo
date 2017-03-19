package com.infosys.datacollect.exception;

public class InstanceNotFoundException extends RuntimeException {

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
