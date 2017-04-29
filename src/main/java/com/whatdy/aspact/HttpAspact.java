package com.whatdy.aspact;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//AOP
@Aspect
@Component
public class HttpAspact
{
    private final static Logger  logger = LoggerFactory.getLogger(HttpAspact.class);
    //切点
    @Pointcut("execution(public * com.whatdy.api.GirlApiController.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_maethod={}",joinPoint.getSignature().getDeclaringTypeName()+" . "+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());




    }
    @After("log()")
    public void doAfter(){
        logger.info("2222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAferReturning(Object object){
        logger.info("response={}",object);
    }
}
