package com.springboot.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class BaseErrorController {

    @GetMapping(value = "/setException")
    public String error(){
        int i=5/0;
        return "ex";
    }

}
