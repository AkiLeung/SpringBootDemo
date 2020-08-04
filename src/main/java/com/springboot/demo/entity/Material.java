package com.springboot.demo.entity;

import com.springboot.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Entity
@Data
public class Material  extends BaseEntity {

    private static final long serialVersionUID = 7667876769646657839L;

    private String uuid;
    private String number;
    private String createdDate;
    private String changedDate;
    private String type;
    private String group;
    private String baseUnit;
    private String salesUnit;
    private String description;

}
