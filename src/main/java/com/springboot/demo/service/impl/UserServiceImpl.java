package com.springboot.demo.service.impl;

import com.springboot.demo.entity.User;
import com.springboot.demo.dao.IUserDao;
import com.springboot.demo.service.IUserService;
import com.springboot.demo.entity.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> listData(PageModel pager) {
        return userDao.listData(pager);
    }

    @Override
    public int listCount(String search) {
        return userDao.listCount(search);
    }

    @Override
    public int insertData(User user) {
        return this.userDao.insertData(user);
    }

    @Override
    public int updateData(User user) {
        return this.userDao.updateData(user);
    }

    @Override
    public int deleteDataById(String uuid) {
        return this.userDao.deleteDataById(uuid);
    }

    @Override
    public User queryDataById(String uuid) {
        return this.userDao.queryDataById(uuid);
    }
}
