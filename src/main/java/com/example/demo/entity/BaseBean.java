package com.example.demo.entity;

import java.util.Date;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/7 16:42
 * @Description:
 */
public class BaseBean {
    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 修改时间
     * */
    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
