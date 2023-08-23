package com.brtpawn.mpps.aop;

import com.brtpawn.mpps.annotation.DataSource;
import com.brtpawn.mpps.multiple.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@within(com.brtpawn.mpps.annotation.DataSource) || @annotation(com.brtpawn.mpps.annotation.DataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource){
        logger.info(new StringBuffer("****选择数据库是：").append(dataSource.value().getValue()).toString());
        DataSourceContextHolder.setDataSource(dataSource.value());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clearDataSource();
    }
}
