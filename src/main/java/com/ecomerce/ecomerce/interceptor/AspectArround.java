package com.ecomerce.ecomerce.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AspectArround {

    Logger logger = LogManager.getLogger(AspectArround.class);

    @Pointcut("execution(* com.ecomerce.ecomerce.controller.ControlladorCliente.*(..)) && !execution(* com.ecomerce.ecomerce.controller.ControlladorCliente.deleteUser(..))")
    void controllerClassMethods() {}

    @Around("controllerClassMethods()")
    Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object ret = joinPoint.proceed();
        long end = System.nanoTime();

        logger.info("Se ejecutó el metodo con una duración de {} ms", TimeUnit.NANOSECONDS.toMillis(end - start));
        return ret;
    }

}