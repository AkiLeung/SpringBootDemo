package com.springboot.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class SysFrameController {

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value = "/system")
    public ModelAndView system() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/sysFrame");
        return modelAndView;
    }

    @RequestMapping(value = "/default")
    public ModelAndView showDefault() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/default");
        return modelAndView;
    }
}
