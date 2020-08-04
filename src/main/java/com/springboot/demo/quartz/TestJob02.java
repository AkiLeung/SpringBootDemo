package com.springboot.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Component("testJob02")
public class TestJob02 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("########## TestJob02任务执行开始：" + new Date());
    }
}