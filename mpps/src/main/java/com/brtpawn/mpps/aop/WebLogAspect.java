package com.brtpawn.mpps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
/**
 * <p>
 * WEB日志的切片类，输出所有的控制类的请求、参数及返回给用户的数据
 * </p>
 *
 * @author liulingxian
 * @version 1.0
 * @since 1.0
 */
//@Aspect
@Component
public class WebLogAspect implements Ordered {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.brtpawn.mpps.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        StringBuffer paramBuffer =new StringBuffer("****请求：").append(request.getRemoteAddr()).append(" ")
                .append(request.getRequestURL()).append(" 的参数为：");
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            paramBuffer.append(name).append("=").append(request.getParameter(name)).append(" ");
        }
        logger.info(paramBuffer.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求返回内容
        logger.info(new StringBuffer("****请求：").append(request.getRequestURL()).append(" 的返回值：").append(ret).toString());
    }

    @Override
    public int getOrder() {
        return 10;
    }
}