package com.springboot.demo.dao;

import com.springboot.demo.entity.SysLog;
import org.springframework.stereotype.Repository;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Repository
public interface IAspectLogDao {

    /**
     * 插入数据
     * @param syslog
     * @return void
     * **/
    int saveAspectLog(SysLog syslog);
}
