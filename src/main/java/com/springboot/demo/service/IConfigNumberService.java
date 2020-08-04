package com.springboot.demo.service;

import com.springboot.demo.entity.ConfigNumber;
import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能说明：
 *
 * @author Joseph
 * @date 20181108
 */
public interface IConfigNumberService {

    /**
     * 查询当前最后的号码
     *
     * @param moduleCode
     * @return ConfigNumber
     */
    //ConfigNumber queryCurrentNumber(String moduleCode);

    /**
     * 更新数据
     * 更新字段：current_range current_value updated_datetime
     * @param configNumber
     * @return int 影响行数
     * **/
    //int updateCurrentNumber(ConfigNumber configNumber);

    /**
     * 更新数据
     * 更新字段：current_range current_value updated_datetime
     * @param moduleCode
     * @return int 影响行数
     * **/
    ConfigNumber generateNewNumber(String moduleCode);
}
