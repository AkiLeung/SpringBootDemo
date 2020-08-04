package com.springboot.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Service
@Primary
@Entity
@Data
public class DruidData {

    /**
     * jdbc
     */
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    /**
     * jdbc connection pool
     * */
    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    /**
     * filter
     * */
    private String filters;

}
