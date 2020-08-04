package com.springboot.demo.controller;

import com.springboot.demo.entity.JsonResult;
import com.springboot.demo.entity.Material;
import com.springboot.demo.service.IMaterialService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Log4j2
@RestController
public class MaterialController {

    @Autowired
    private IMaterialService materialService;

    @GetMapping(value = "/listMaterial")
    public JsonResult listMaterial(Model model,
                                   @RequestParam(value = "curPage", required = false) Integer curPage) {
        List<Material> materialList = null;
        int pageSize = 5;
        if (null == curPage) {
            curPage = 1;
        }

        //总数
        int totalRows = materialService.listCount("");
        //分页信息你
        Map<String, Object> paramMap = getPager(curPage,pageSize,totalRows);
        try {
            materialList = materialService.listData(paramMap);
        } catch (Exception ex) {
            log.error("exception:" + ex.toString());
        }
        return JsonResult.ok(materialList);
    }

    @RequestMapping(value = "/showMaterial")
    public ModelAndView showMaterial(Model model,
                                     @RequestParam(value = "curPage", required = false) Integer curPage) {
        ModelAndView modelAndView = new ModelAndView();
        List<Material> materialList = null;

        int pageSize = 50;

        //总数
        int totalRows = materialService.listCount("");
        //分页信息你
        Map<String, Object> paramMap = getPager(curPage,pageSize,totalRows);
        try {
            materialList = materialService.listData(paramMap);
        } catch (Exception ex) {
            log.error("exception:" + ex.toString());
        }

        model.addAttribute("totalPages", paramMap.get("totalPages"));
        model.addAttribute("materialList", materialList);

        modelAndView.setViewName("views/showMaterial");
        return modelAndView;
    }

    /**
     * 计算分页信息
     * */
    private Map<String, Object> getPager(Integer curPage,int pageSize,int totalRows) {
        Map<String, Object> paramMap;
        if (null == curPage) {
            curPage = 1;
        }
        //计算分页
        int totalPages = totalRows / pageSize;
        //有可能有余数
        int left = totalRows % pageSize;
        if (left > 0) {
            totalPages = totalPages + 1;
        }
        //计算查询的开始行
        int startRow = (curPage - 1) * pageSize;
        paramMap = new ConcurrentHashMap<>(3);
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        paramMap.put("totalPages", totalPages);
        return paramMap;
    }

}
