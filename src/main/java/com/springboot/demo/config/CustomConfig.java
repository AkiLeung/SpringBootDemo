package com.springboot.demo.config;

import com.springboot.demo.base.BaseEntity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Configuration
@ConfigurationProperties(prefix="custom.system")
@PropertySource("classpath:custom.properties")
@Component
@Data
@Entity
public class CustomConfig extends BaseEntity {

    private static final long serialVersionUID = 5091879679443336587L;

    private String name;
    private String author;
}
