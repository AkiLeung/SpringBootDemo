package com.springboot.demo.controller;

import com.springboot.demo.entity.ConfigNumber;
import com.springboot.demo.service.IConfigNumberService;
import com.springboot.demo.utils.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class ConfigNumberController {

    @Autowired
    private IConfigNumberService configNumberService;

    @GetMapping(value = "/number/{moduleCode}")
    public String generateNextNumber(@PathVariable("moduleCode") String moduleCode) {
        String numberFormat;
        String nextNumber = "";
        try {
            //获取信息号码对象
            ConfigNumber configNumber = configNumberService.generateNewNumber(moduleCode);
            //获取成功，串写号码
            if (null != configNumber) {
                //默认位数补0
                numberFormat = "%0" + configNumber.getDefaultLength() + "d";
                //串写号码
                if ("" != configNumber.getCurrentRange()) {
                    nextNumber = configNumber.getPreNumWord() + "-"
                            + configNumber.getCurrentRange() + "-"
                            + String.format(numberFormat, configNumber.getCurrentValue());
                } else {
                    nextNumber = configNumber.getPreNumWord() + "-"
                            + String.format(numberFormat, configNumber.getCurrentValue());
                }
            }
        }
        catch (Exception e){
            log.error(e.toString());
            return e.toString();
        }
        return nextNumber;
    }
}
