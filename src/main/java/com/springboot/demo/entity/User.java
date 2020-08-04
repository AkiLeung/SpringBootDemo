package com.springboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Joseph.L
 * @date 2020-05-08
 * @description User
 */
@Data
@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 1406042485206108930L;

    @Id
    private String uuid;

    /**
     * 这是和数据表对应的一个列
     * 省略(name = "username", length = 30)默认列名就是属性名
     */
    @Column(name = "username", length = 30)
    private String username;

    @JsonIgnore
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;

}
