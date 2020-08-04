package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@RestController
public class I18nController {

    @RequestMapping("/i18nTest")
    public ModelAndView i18nTest(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("views/i18nTest");
        return mv;
    }
}
