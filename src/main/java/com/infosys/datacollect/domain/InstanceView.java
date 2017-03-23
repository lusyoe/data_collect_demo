package com.infosys.datacollect.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 实例视图
 * @author luhaoyuan <lusyoe@163.com>
 * @description 实例视图
 * @version 1.0.0
 * @date 2017年3月18日
 */
public class InstanceView {

    private String name;
    private String typeName;
    private String categoryName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "InstanceView{" +
                "name='" + name + '\'' +
                ", typeName='" + typeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}