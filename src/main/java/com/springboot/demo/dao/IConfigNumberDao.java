package com.springboot.demo.dao;


import com.springboot.demo.entity.ConfigNumber;
import org.springframework.stereotype.Repository;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Repository
public interface IConfigNumberDao {

    /**
     * 查询当前最后的号码
     *
     * @param moduleCode
     * @return ConfigNumber
     */
    ConfigNumber queryCurrentNumber(String moduleCode);

    /**
     * 更新数据
     * 更新字段：current_range current_value updated_datetime
     * @param configNumber
     * @return int 影响行数
     * **/
    int updateCurrentNumber(ConfigNumber configNumber);

}
