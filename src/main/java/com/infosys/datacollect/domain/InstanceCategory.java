package com.infosys.datacollect.domain;

import java.io.Serializable;

public class InstanceCategory implements Serializable {

    private static final long serialVersionUID = -8343221343466030935L;

    private Integer id;

    private String name;

    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}