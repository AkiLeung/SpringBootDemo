package com.springboot.demo.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Joseph.L
 * @date 2019-10-28
 * @description 日志管理连接字符串
 */
@Log4j2
public class ConLog4j2Utils {

    /**
     * Druid数据源
     */
    private DruidDataSource dataSource;

    /**
     * 连接对象
     */
    private static ConLog4j2Utils connection;

    /**
     * 获取连接
     */
    public Connection setConnection() throws SQLException {
        //读取配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("log4j2-dbConfig");
        Properties result = new Properties();
        result.put("driverClassName", bundle.getString("connection.driverClassName"));
        result.put("url", bundle.getString("connection.url"));
        result.put("username", bundle.getString("connection.username"));
        result.put("password", bundle.getString("connection.password"));
        result.put("maxActive", "30");
        result.put("minIdle", "3");
        try {
            //创建数据源
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(result);
        } catch (Exception ex) {
            log.error("ConLog4j2Utils:" + ex.toString());
        }
        return dataSource.getConnection();
    }

    /**
     * 返回连接对象
     */
    public static Connection getDataSourceConnection() throws SQLException {
        if (connection == null) {
            connection = new ConLog4j2Utils();
        }
        return connection.setConnection();
    }
}
