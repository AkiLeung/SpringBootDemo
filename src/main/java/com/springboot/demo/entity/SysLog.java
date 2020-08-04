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
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 5645151291243143579L;

    private String uuid;
    private String username;
    private String operation;
    private long time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}
