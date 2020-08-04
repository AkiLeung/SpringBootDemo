package com.springboot.demo.handler;

import com.springboot.demo.commom.ApiResponse;
import com.springboot.demo.exception.JsonException;
import com.springboot.demo.exception.PageException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error/error";

    @ExceptionHandler(value = Exception.class)
    public static Object errorHandler(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Exception ex){
        //记录错误信息到数据库
        log.error("统一异常处理  :"+ex.getClass());

        String exception = ex.getClass() + ex.getMessage();

        //指定要处理的异常
        String ArithmeticException = "class java.lang.ArithmeticException";
        String exClass = ex.getClass().toString().trim().toUpperCase();
        //可以在此处根据异常类型对不想暴露出去用户界面的信息进行加工
        if(ArithmeticException.trim().toUpperCase().equals(exClass)){
            exception = "ArithmeticException:It's none of your business!!";
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception);
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    /**
     * 统一 json 异常处理
     *
     * @param exception JsonException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception) {
        log.error("【JsonException】:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }

    /**
     * 统一 页面 异常处理
     *
     * @param exception PageException
     * @return 统一跳转到异常页面
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception) {
        log.error("【DemoPageException】:{}", exception.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message", exception.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }
}