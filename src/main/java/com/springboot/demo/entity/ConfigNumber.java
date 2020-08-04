package com.springboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Entity
@Data
public class ConfigNumber extends BaseEntity {

    private static final long serialVersionUID = -1836461833347636880L;

    @Column(name = "id")
    private int id;

    @Column(name = "module_code", length = 20)
    private String moduleCode;

    @Column(name = "module_name", length = 50)
    private String moduleName;

    @Column(name = "pre_num_word", length = 30)
    private String preNumWord;

    @Column(name = "increment_range", length = 8)
    private String incrementRange;

    @Column(name = "default_length")
    private int defaultLength;

    @Column(name = "current_range")
    private String currentRange;

    @Column(name = "current_value")
    private int currentValue;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private String createdDatetime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private String updatedDatetime;

}
