package com.springboot.demo.controller;

import com.springboot.demo.config.QuartzConfig;
import com.springboot.demo.entity.ScheduleJob;
import com.springboot.demo.service.IScheduleJobService;
import lombok.extern.log4j.Log4j2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class ScheduleJobController {

    @Autowired
    private IScheduleJobService scheduleJobService;

    @Autowired
    private QuartzConfig quartzConfig;

    @GetMapping("/simpleScheduleJob-Start")
    public String testJobStart() throws Exception {
        // 创建scheduler
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        // 创建JobDetail
//        JobDetail jobDetail = JobBuilder.newJob(
//                (Class<? extends Job>) Class.forName("com.springboot.demo.quartz.JobSchedule")).
//                withIdentity("jobTest", "group2").
//                build();
//
//        // 指定时间触发，每隔2s执行一次，重复20次
//        Trigger trigger2 = newTrigger()
//                .withIdentity("trigger1", "group1")
//                //开始时间：当前时间 = 立即
//                .startAt(new Date())
//                //设置简单计划
//                .withSchedule(simpleSchedule()
//                        //重复执行间隔
//                        .withIntervalInSeconds(2)
//                        //永久执行
//                        .repeatForever()
//                        //重复次数:3 表示执行4次
//                        //.withRepeatCount(3)
//                        )
//                .build();
//
//        scheduler.scheduleJob(jobDetail, trigger2);
//        scheduler.start();

        return "开始执行-TestJob";
    }

    @GetMapping("/simpleScheduleJob-Over")
    public String testJobOver() throws Exception {
//        log.info("终止TestJob");
//
//        // 创建scheduler
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        // 创建JobDetail
//        JobDetail jobDetail = JobBuilder.newJob(
//                (Class<? extends Job>) Class.forName("com.springboot.demo.quartz.JobSchedule")).
//                withIdentity("jobTest", "group2").
//                build();
//
//        scheduler.deleteJob(jobDetail.getKey());
//
        return "结束执行-TestJob";
    }


    @GetMapping("/setAllJobStart")
    public String setAllJobStart() throws Exception {

        List<ScheduleJob> scheduleJobs = scheduleJobService.listData();

        try {
            for (ScheduleJob scheduleJob : scheduleJobs) {
                // 创建scheduler //StdSchedulerFactory.getDefaultScheduler();
                Scheduler scheduler = quartzConfig.scheduler();
                // 创建JobDetail
                JobDetail jobDetail = JobBuilder.newJob(
                        (Class<? extends Job>) Class.forName(scheduleJob.getJobClass())).
                        withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).
                        build();

                // 指定时间触发，每隔2s执行一次，重复20次
//                Trigger trigger = newTrigger()
//                        .withIdentity(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroup())
//                        //开始时间：当前时间 = 立即
//                        .startAt(new Date())
//                        //设置简单计划
//                        .withSchedule(simpleSchedule()
//                                        //重复执行间隔
//                                        .withIntervalInSeconds(2)
//                                        //永久执行
//                                        .repeatForever()
//                                //重复次数:3 表示执行4次
//                                //.withRepeatCount(3)
//                        )
//                        .build();

                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroup())
                        .withSchedule(
                                //执行频率
                                CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpr())
                        ).build();

                scheduler.scheduleJob(jobDetail, trigger);
                scheduler.start();
            }
        } catch (SchedulerException ex) {
            ex.printStackTrace();
        }

        return "设置所有Job开始";
    }

    @GetMapping("/setAllJobStop")
    public String setAllJobStop() throws Exception {

        List<ScheduleJob> scheduleJobs = scheduleJobService.listData();

        try {
            for (ScheduleJob scheduleJob : scheduleJobs) {
                // 创建scheduler
                Scheduler scheduler = quartzConfig.scheduler();

                // 创建JobDetail
                JobDetail jobDetail = JobBuilder.newJob(
                        (Class<? extends Job>) Class.forName(scheduleJob.getJobClass())).
                        withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).
                        build();

                scheduler.deleteJob(jobDetail.getKey());
            }
        } catch (SchedulerException ex) {
            ex.printStackTrace();
        }

        return "设置所有Job结束";
    }
}
