package com.brtpawn.mpps.aop;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.brtpawn.mpps.utils.MD5Util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019-10-30.
 */
@Aspect
@Component
public class CallAuthorityAop implements Ordered {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    public static String AUTHORITY_KEY= "Wecdw78jis";

    @Pointcut("execution(public * com.brtpawn.mpps.controller.*.*(..))")
    public void callAuthority() {
    }

    @Before("callAuthority()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        ///URI能得到类似这样的值mpps/user/getUserInfoByPKey，鉴权码的生成方法D5(methodId=sendSms&clientId=mpbs&key=Wecdw78jis)
        String[] pathNames = request.getRequestURI().split("/");
        if(pathNames.length<1){
            throw new RuntimeException("请求路径为空！");
        }
        Enumeration<String> params = request.getParameterNames();
        StringBuffer paramBuffer =new StringBuffer("methodId=").append(pathNames[pathNames.length-1])
                .append("&clientId=").append(request.getParameter("clientId"))
                .append("&key=").append(request.getParameter(AUTHORITY_KEY));
        String authorityKey = request.getParameter("authorityKey");
        if(!MD5Util.encrypt(paramBuffer.toString()).equals(authorityKey)){
            throw new RuntimeException("接口鉴权请求没通过！");
        };
        //logger.info(paramBuffer.toString());
    }

    @Override
    public int getOrder() {
        return 11;
    }

}
