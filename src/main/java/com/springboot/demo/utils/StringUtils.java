package com.springboot.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.entity.PageModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Joseph.L
 * @date 2019-10-28
 * @description 工具：文本工具方法集合
 */
public class StringUtils {

    /**
     * 主方法-测试
     */
    public static void main(String[] args) {
        String uuid = createUUID();
        System.out.println(uuid);
    }

    /**
     * 生成UUID
     *
     * @return uuid
     * @author Joseph.L
     */
    public static String createUUID() {
        //获取UUID并转化为String对象
        String uuid = UUID.randomUUID().toString();
        //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     *
     * @param s
     * @return
     * @author Joseph.L
     */
    public static boolean isEmpty(String s) {
        if (s != null && !s.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 获取当前日期和时间
     */
    public static String getDatetime() {
        Date date = new Date();
        //设置日期格式
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = df.format(date);
        return dateTime;
    }

    /**
     * 轉換日期和时间
     */
    public static String toDatetime(String strDatetime) {
        //设置日期格式
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = df.format(strDatetime);
        return dateTime;
    }

    /**
     * 功能说明：分页数据处理
     *
     * @param request
     * @param listCount
     * @return PageModel-pager
     * @author Joseph
     * @date 20181101
     */
    public static PageModel getPager(HttpServletRequest request, Integer listCount) throws Exception {
        //獲取分頁情況
        int page = 1; //Integer.parseInt(request.getParameter("page"));
        int rows = 10; //Integer.parseInt(request.getParameter("rows"));
        int startRow = 0;
        if (page > 1) {
            startRow = (page - 1) * rows;
        }
        PageModel pager = new PageModel();
        pager.setStartRow(startRow);
        pager.setRows(rows);
        pager.setTotal(listCount);
        return pager;
    }

    /**
     * 功能说明：回寫數據流（UTF-8）-分页
     *
     * @param response
     * @param listCount
     * @param jsonArray
     * @author Joseph
     * @date 20181101
     */
    public static void writePager(HttpServletResponse response, int listCount, JSONArray jsonArray) throws Exception {
        //数据内容
        JSONObject resultSet = new JSONObject();
        resultSet.put("rows", jsonArray);
        resultSet.put("total", listCount);
        //输出流
        write(response, resultSet);
    }

    /**
     * 功能说明：回寫數據流（UTF-8）
     *
     * @param response
     * @param object
     * @author Joseph
     * @date 20181101
     */
    public static void write(HttpServletResponse response, Object object) throws Exception {
        PrintWriter out = response.getWriter();
        response.reset();
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        out.println(object.toString());
        out.flush();
        out.close();
    }
}
