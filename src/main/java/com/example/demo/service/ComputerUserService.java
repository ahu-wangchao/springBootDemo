package com.example.demo.service;

import com.example.demo.entity.ComputerUser;

import java.util.List;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 14:20
 * @Description: 用户服务类接口
 */
public interface ComputerUserService {
    /**
     *插入用户
     * */
    void add(ComputerUser user);
    /**
     *查询用户列表
     * */
    List<ComputerUser> selectList();
    /**
     *根据ID精确查询
     * */
    ComputerUser selectById(long id);
}
