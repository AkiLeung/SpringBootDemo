package com.springboot.demo.service.impl;

import com.springboot.demo.dao.IScheduleJobDao;
import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.ScheduleJob;
import com.springboot.demo.service.IScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleJobServiceImpl implements IScheduleJobService {

    @Autowired
    private IScheduleJobDao scheduleJobDao;

    @Override
    public List<ScheduleJob> listData() {
        return scheduleJobDao.listData();
    }

    @Override
    public int listCount(String search) {
        return scheduleJobDao.listCount("");
    }

    @Override
    public ScheduleJob queryDataById(String jobId) {
        return null;
    }

    @Override
    public int insertData(ScheduleJob entity) {
        return 0;
    }

    @Override
    public int updateData(ScheduleJob entity) {
        return 0;
    }

    @Override
    public int deleteDataById(String jobId) {
        return 0;
    }
}
