package com.springboot.demo.service;

import com.springboot.demo.entity.User;
import com.springboot.demo.entity.PageModel;

import java.util.List;

/**
 * 功能说明：
 *
 * @author Joseph
 * @date 20181108
 */
public interface IUserService {

    /**
     * 查询所有
     *
     * @param pager 分頁信息
     * @return List<User>
     */
    List<User> listData(PageModel pager);

    /**
     * 查询所有
     *
     * @return int 返回行數
     */
    int listCount(String search);

    User queryDataById(String uuid);

    int insertData(User user);

    int updateData(User user);

    int deleteDataById(String uuid);

}
