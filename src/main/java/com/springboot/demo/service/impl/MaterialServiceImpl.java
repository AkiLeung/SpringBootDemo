package com.springboot.demo.service.impl;

import com.springboot.demo.dao.IMaterialDao;
import com.springboot.demo.dao.IUserDao;
import com.springboot.demo.entity.Material;
import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.IMaterialService;
import com.springboot.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private IMaterialDao materialDao;

    @Override
    public List<Material> listData(Map<String,Object> params) {
        return materialDao.listData(params);
    }

    @Override
    public int listCount(String search) {
        return materialDao.listCount(search);
    }
}
