package com.example.demo.service.impl;

import com.example.demo.dao.ComputerUserDao;
import com.example.demo.entity.ComputerUser;
import com.example.demo.service.ComputerUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 14:21
 * @Description:
 */
@Service
public class ComputerUserServiceImpl implements ComputerUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComputerUserServiceImpl.class);
    @Resource
    private ComputerUserDao computerUserDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(ComputerUser user) {
        computerUserDao.insert(user);
    }

    @Override
    public List<ComputerUser> selectList() {
        return computerUserDao.selectList();
    }

    @Override
    public ComputerUser selectById(long id) {
        return computerUserDao.selectById(id);
    }
}
