package com.springboot.demo.dao;

import com.springboot.demo.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@Repository
public interface IMaterialDao {

    /**
     * 查询所有
     *
     * @param params 分頁信息
     * @return List<Material>
     */
    List<Material> listData(Map<String,Object> params);

    /**
     * 查询所有
     *
     * @param search 分頁信息
     * @return int 影響行數
     */
    int listCount(String search);

}
