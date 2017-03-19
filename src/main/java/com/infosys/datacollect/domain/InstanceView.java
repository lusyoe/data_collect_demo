package com.infosys.datacollect.domain;

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

    @Override
    public String toString() {
        return "Instance [name=" + name + ", typeName=" + typeName + ", categoryName=" + categoryName + "]";
    }

    
}