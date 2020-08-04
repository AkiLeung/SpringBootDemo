package com.springboot.demo.service;

import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.ScheduleJob;

import java.util.List;

/**
 * 功能说明：
 *
 * @author Joseph
 * @date 20181108
 */
public interface IScheduleJobService {

    /**
     * 查询所有
     *
     * @return List<ScheduleJob>
     */
//    List<ScheduleJob> list();

    /**
     * 查询所有
     *
     * @return List<ScheduleJob>
     */
    List<ScheduleJob> listData();

    /**
     * 查询所有
     * @param search 查询条件
     * @return int 返回行數
     */
    int listCount(String search);

    /**
     * 查询所有
     * @param jobId 按ID查询
     * @return ScheduleJob 返回行數
     */
    ScheduleJob queryDataById(String jobId);

    /**
     * 插入数据
     * @param entity 操作对象
     * @return int 返回行數
     */
    int insertData(ScheduleJob entity);

    /**
     * 更新数据
     * @param entity 操作对象
     * @return int 返回行數
     */
    int updateData(ScheduleJob entity);

    /**
     * 删除数据
     * @param jobId 按ID查询
     * @return int 返回行數
     */
    int deleteDataById(String jobId);
}
