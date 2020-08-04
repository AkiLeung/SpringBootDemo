package com.springboot.demo.aspect;

import com.springboot.demo.annotation.AspectLog;
import com.springboot.demo.dao.IAspectLogDao;
import com.springboot.demo.entity.SysLog;
import com.springboot.demo.utils.CommonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;
/**
 * @author Joseph.L
 * @date
 * @description
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private IAspectLogDao iAspectLogDao;

    @Pointcut("execution(public * com.springboot.demo.controller.*.*(..)) && @annotation(com.springboot.demo.annotation.AspectLog)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object  around(ProceedingJoinPoint proceedingJoinPoint) {
        long beginTime = System.currentTimeMillis();
        Object ret= null;
        try {
            System.out.println("*************around begin*****************");
            ret= proceedingJoinPoint.proceed();
            System.out.println("*************around end*****************");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(proceedingJoinPoint, time);
        return ret;
    }

//    @Before(value = "pointcut()")
//    public void before(JoinPoint joinPoint){
//        System.out.println("*************pointcut before*****************");
//    }
//
//    @After(value = "pointcut()")
//    public void after(JoinPoint joinPoint){
//        System.out.println("*************pointcut after*****************");
//    }
//
//    @AfterReturning(pointcut = "@annotation(com.springboot.demo.annotation.AspectLog)",returning = "ret")
//    public void doAfterReturning(Object ret){
//        System.out.println("*************pointcut AfterReturning *****************方法的返回值 : " + ret);
//    }
//
//    @AfterThrowing(pointcut = "@annotation(com.springboot.demo.annotation.AspectLog)",throwing = "ex")
//    public void AfterThrowing(JoinPoint joinPoint,Throwable ex){
//        System.out.println("*************pointcut AfterThrowing *****************方法执行异常 : " + ex);
//    }

    private int saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog logger = new SysLog();
        AspectLog aspectLogAnnotation = method.getAnnotation(AspectLog.class);

        logger.setUuid(UUID.randomUUID().toString());
        if (aspectLogAnnotation != null) {
            // 注解上的描述
            logger.setOperation(aspectLogAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logger.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            logger.setParams(params);
        }
        // 获取request
        HttpServletRequest request = CommonUtils.getHttpServletRequest();
        // 设置IP地址
        logger.setIp(CommonUtils.getIpAddress(request));
        // 模拟一个用户名
        logger.setUsername("joseph");
        logger.setTime(time);
        logger.setCreateTime(new Date());

        // 保存系统日志
        return (iAspectLogDao.saveAspectLog(logger)) ;
    }
}
