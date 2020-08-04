package com.springboot.demo.dao;

import com.springboot.demo.entity.User;
import com.springboot.demo.entity.PageModel;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@Repository
public interface IUserDao {

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
     * @return int 影響行數
     */
    int listCount(String search);

    /**
     * 只查询一个，常用于修改
     *
     * @param uuid
     * @return User
     */
    User queryDataById(String uuid);

    /**
     * 插入数据
     * @param entity
     * @return int 影响行数
     * **/
    int insertData(User entity);

    /**
     * 更新数据
     * @param entity
     * @return int 影响行数
     * **/
    int updateData(User entity);

    /**
     * 删除数据
     * @param uuid
     * @return int 影响行数
     * **/
    int deleteDataById(String uuid);

}
