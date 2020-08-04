package com.springboot.demo.controller;

import com.springboot.demo.annotation.AspectLog;
import com.springboot.demo.entity.JsonResult;
import com.springboot.demo.entity.PageModel;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.IUserService;
import com.springboot.demo.utils.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    //@AspectLog("/listUser/{uuid}")
    @GetMapping(value = "/listUser/{uuid}")
    public User GetUserById(@PathVariable("uuid") String uuid) {
        return this.userService.queryDataById(uuid);
    }

    @GetMapping(value = "/listUser")
    public JsonResult listUser(HttpServletRequest request) {
        log.info("L4J2********测试方法ListUser");
        List<User> userList = null;
        try {
            Integer listCount = userService.listCount("");
            PageModel pager = StringUtils.getPager(request, listCount);
            userList = userService.listData(pager);
        } catch (Exception ex) {
            log.error("exception:" + ex.toString());
        }
        return JsonResult.ok(userList);
    }

    @AspectLog("测试方法listCount")
    @GetMapping(value = "/listCount")
    public Integer listCount() {
        Integer listCount = userService.listCount("");
        return listCount;
    }

    @AspectLog("测试方法helloWorld")
    @GetMapping(value = "/helloWorld")
    public String helloWorld() {
        return "Test 132";
    }
}
