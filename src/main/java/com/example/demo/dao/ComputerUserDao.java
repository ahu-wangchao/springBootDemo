package com.example.demo.dao;

import com.example.demo.entity.ComputerUser;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 14:21
 * @Description:
 */
public interface ComputerUserDao {
    void insert(ComputerUser user);

    List<ComputerUser> selectList();

    ComputerUser selectById(long id);

    void update(ComputerUser computerUser);
}
