package com.springboot.demo.service.impl;

import com.springboot.demo.dao.IConfigNumberDao;
import com.springboot.demo.entity.ConfigNumber;
import com.springboot.demo.service.IConfigNumberService;
import com.springboot.demo.utils.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@Service
public class ConfigNumberServiceImpl implements IConfigNumberService {

    @Autowired
    private IConfigNumberDao configNumberDao;

//    @Override
//    public ConfigNumber queryCurrentNumber(String moduleCode) {
//        return configNumberDao.queryCurrentNumber(moduleCode);
//    }
//
//    @Override
//    @Transactional(rollbackFor = exception.class)
//    public int updateCurrentNumber(ConfigNumber configNumber) {
//        return configNumberDao.updateCurrentNumber(configNumber);
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConfigNumber generateNewNumber(String moduleCode) {
        ConfigNumber targetNumber = null;
        //设置日期格式
        SimpleDateFormat dateFormat;
        Date date = new Date();
        //获取当前号码
        ConfigNumber currentNumber = configNumberDao.queryCurrentNumber(moduleCode);
        if (null != currentNumber) {
            if ("" == currentNumber.getIncrementRange()) {
                //永久持续递增
                currentNumber.setCurrentRange("");
                //号码默认:+1
                currentNumber.setCurrentValue(currentNumber.getCurrentValue() + 1);
            } else {
                //按年/月/日条件递增
                dateFormat = new java.text.SimpleDateFormat(currentNumber.getIncrementRange());
                if (dateFormat.format(date).equals(currentNumber.getCurrentRange())) {
                    //范围内自递增
                    currentNumber.setCurrentValue(currentNumber.getCurrentValue() + 1);
                } else {
                    //范围外重新赋值
                    currentNumber.setCurrentRange(dateFormat.format(date));
                    currentNumber.setCurrentValue(1);
                }
            }
        }
        //更新时间
        currentNumber.setUpdatedDatetime(StringUtils.getDatetime());
        //更新到下一个号码
        int update = configNumberDao.updateCurrentNumber(currentNumber);
        //**********************************************************制造异常**************S
        //int a = 10, b = 0, c = 0;
        //c = a / b;
        //**********************************************************制造异常**************E
        //获取更新后的号码
        if (update > 0) {
            targetNumber = currentNumber;
            return targetNumber;
        }
        return null;
    }

}
