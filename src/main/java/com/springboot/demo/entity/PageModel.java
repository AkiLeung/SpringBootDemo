package com.springboot.demo.entity;

import com.springboot.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 功能說明：分頁模型
 *
 * @author JOSEPH.L
 * @version 1.0
 * @date 20181203
 * */
@Data
@Entity
public class PageModel extends BaseEntity {

    private static final long serialVersionUID = 5214805478108514905L;

    /**
     * 查询条件01
     * */
    private String condition01;

    /**
     * 查询条件02
     * */
    private String condition02;

    /**
     * 查询条件03
     * */
    private String condition03;

    /**
     * 查询条件04
     * */
    private String condition04;

    /**
     * 查询条件04
     * */
    private String condition05;

    /**
     * 查询起始行
     * */
    private Integer startRow;

    /**
     * 查询结果数据
     * */
    private Integer rows;

    /**
     * 总记录行数
     * */
    private Integer total;
}
