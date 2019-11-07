package com.example.demo.entity;

import java.util.Date;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 14:25
 * @Description: 用户类型
 */
public class UserType {
    private Long id;
    private String typeName;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
