package com.springboot.demo.dao;

import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.ScheduleJob;
import com.springboot.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@Repository
public interface IScheduleJobDao {

    /**
     * 查询所有
     * @return List<ScheduleJob>
     */
    List<ScheduleJob> listData();

    /**
     * 查询所有
     * @param search 查询条件
     * @return int 影響行數
     */
    int listCount(String search);

    /**
     * 只查询一个，常用于修改
     *
     * @param JobId
     * @return ScheduleJob
     */
    ScheduleJob queryDataById(String JobId);

    /**
     * 插入数据
     * @param entity
     * @return int 影响行数
     * **/
    int insertData(ScheduleJob entity);

    /**
     * 更新数据
     * @param entity
     * @return int 影响行数
     * **/
    int updateData(ScheduleJob entity);

    /**
     * 删除数据
     * @param JobId
     * @return int 影响行数
     * **/
    int deleteDataById(String JobId);

}
