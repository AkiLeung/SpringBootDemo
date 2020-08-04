package com.springboot.demo.quartz;

import com.springboot.demo.service.impl.UserServiceImpl;
import com.springboot.demo.utils.SpringUtils;
import lombok.extern.log4j.Log4j2;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@Component("testJob01")
public class TestJob01 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        //ServiceImpl中必须填写名称
        UserServiceImpl userServiceImpl =(UserServiceImpl) SpringUtils.getBean("userServiceImpl");
        log.info("************* TestJob01任务执行开始：" + new Date());
        log.info("************* 查询用户个数：" + userServiceImpl.listCount(""));
        log.info("************* TestJob01任务执行结束：" + new Date());
    }
}
