package com.summer.validation.controller.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author: create by Summer.Xiong
 * @version: v1.0
 * @description:
 * @date: 2020/3/22 15:29
 */
@Slf4j
@Aspect //使用@Aspect注解声明一个切面
@Component
@Order(2)
public class BindingResultAspect {

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     * 例如: @Pointcut("@annotation(com.summer.demo.anno.SysLog)")
     */
    @Pointcut("execution(public * com.summer.validation.controller.*.*(..))")
    public void bidingResultPointCut(){
    }

    /**
     * 环绕通知 @Around ，当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("bidingResultPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if(fieldError != null){
                        log.error("参数校验失败:" + fieldError.getDefaultMessage());
                        /**
                         * 实际项目中此处可以抛出对应的异常，或者通过通用的返回构造类构造错误参数的返回对象
                         */
                    }else{
                        log.error("参数校验失败:" + fieldError);
                    }
                }
            }
        }
        return joinPoint.proceed();
    }
}
