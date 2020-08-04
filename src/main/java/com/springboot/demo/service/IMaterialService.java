package com.springboot.demo.service;

import com.springboot.demo.entity.Material;

import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 *
 * @author Joseph
 * @date 20181108
 */
public interface IMaterialService {

    /**
     * 查询所有
     *
     * @param params 分頁信息
     * @return List<Material>
     */
    List<Material> listData(Map<String,Object> params);

    /**
     * 查询所有
     * @param search 分頁信息
     * @return int 返回行數
     */
    int listCount(String search);
}
