package com.example.demo.action;

import com.example.demo.entity.BaseBean;

import java.util.Date;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/7 16:45
 * @Description:
 */
public class BaseController {
    protected void setCreateInfo(BaseBean baseBean){
        baseBean.setCreateTime(new Date());
        baseBean.setModifyTime(new Date());
    }
}
