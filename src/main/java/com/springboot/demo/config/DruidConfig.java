package com.springboot.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.springboot.demo.entity.DruidData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Configuration
@EnableConfigurationProperties({DruidData.class})
public class DruidConfig {

    @Autowired
    private DruidData druidData;


    /**
     *  主要实现WEB监控的配置处理
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        // 现在要进行druid监控的配置处理操作
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");

//        Map<String,String> initParams =new HashMap<>(5);
//        initParams.put("allow", "127.0.0.1,172.29.32.54");
//        initParams.put("deny", "192.168.1.110");
//        initParams.put("loginUsername", "admin");
//        initParams.put("loginPassword", "123456");
//        initParams.put("resetEnable", "false");
//        servletRegistrationBean.setInitParameters(initParams);

        // 白名单,多个用逗号分割， 如果allow没有配置或者为空，则允许所有访问
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1,172.29.32.54");
        // 黑名单,多个用逗号分割 (共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.110");
        // 控制台管理用户名
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        // 控制台管理密码
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否可以重置数据源，禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     *  静态资源过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
        filterRegistrationBean.setFilter(new WebStatFilter());
        //所有请求进行监控处理
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

//        Map<String,String> initParams =new HashMap<>(1);
//        initParams.put("exclusions", "*.bootstrap,*.gif,*.jpg,*.css,/druid/*");
//        filterRegistrationBean.setInitParameters(initParams);

        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.bootstrap,*.gif,*.jpg,*.css,/druid/*");
        return filterRegistrationBean ;
    }

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(druidData.getDriverClassName());
        druidDataSource.setUrl(druidData.getUrl());
        druidDataSource.setUsername(druidData.getUsername());
        druidDataSource.setPassword(druidData.getPassword());
        druidDataSource.setInitialSize(druidData.getInitialSize());
        druidDataSource.setMinIdle(druidData.getMinIdle());
        druidDataSource.setMaxActive(druidData.getMaxActive());
        druidDataSource.setMaxWait(druidData.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(druidData.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(druidData.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(druidData.getValidationQuery());
        druidDataSource.setTestWhileIdle(druidData.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(druidData.isTestOnBorrow());
        druidDataSource.setTestOnReturn(druidData.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(druidData.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidData.getMaxPoolPreparedStatementPerConnectionSize());
        return druidDataSource;
    }
}
