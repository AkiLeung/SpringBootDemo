package com.springboot.demo.entity;

import com.springboot.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Data
@Entity
public class ScheduleJob extends BaseEntity {

    private static final long serialVersionUID = 6794278233339581395L;

    /**
     * 这个类用于展示定时的任务，同时作用于定时任务的恢复、删除、中止；
     **/
    private int jobId;

    /**
     * 任务类的全限定类名
     */
    private String jobClass;

    /**
     * 任务组名
     */
    private String jobGroup;

    /**
     * 任务名
     */
    private String jobName;

    /**
     * 任务触发器名
     */
    private String triggerName;

    /**
     * 任务触发器组名
     */
    private String triggerGroup;

    /**
     * 时间表达式
     */
    private String cronExpr;

    /**
     * 任务状态
     */
    private int status;

    /**
     * 任务状态
     */
    private int deleteFlag;
    /**
     * 任务开始时间
     */
    private Date startTime;

    /**
     * 任务创建时间
     */
    private Date createdTime;

    /**
     * 任务修改时间
     */
    private Date updatedTime;

}
