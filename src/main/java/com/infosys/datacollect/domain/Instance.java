package com.infosys.datacollect.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Instance {

    @ApiModelProperty(hidden = true)
    private Integer id;
    
    @NotBlank
    @ApiModelProperty(value = "实例名称", example = "Test")
    private String name;
    
    @NotNull
    @ApiModelProperty(value = "实例类别", example = "1")
    private Integer typeId;
    
    @NotNull
    @ApiModelProperty(value = "实例类型", example = "2")
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
