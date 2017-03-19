package com.infosys.datacollect.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Instance {

    private Integer id;
    
    @NotBlank
    private String name;
    
    @NotNull
    private Integer typeId;
    
    @NotNull
    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Instance [id=" + id + ", name=" + name + ", typeId=" + typeId + ", categoryId=" + categoryId + "]";
    }

}
