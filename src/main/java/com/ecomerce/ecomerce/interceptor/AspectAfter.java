package com.ecomerce.ecomerce.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfter {

    Logger logger = LogManager.getLogger(AspectAfter.class);

    @Pointcut("execution(* com.ecomerce.ecomerce.controller.ControlladorCliente.updateConfig(..))")
    void alTerminarMetodoUpdate() {
    }

    @Pointcut("execution(* com.ecomerce.ecomerce.controller.ControlladorCliente.deleteUser(..))")
    void alTerminarMetodoDelete() {
    }

    @Pointcut("execution(* com.ecomerce.ecomerce.controller.ControlladorCliente.updateConfig(..))")
    void alTerminarHacerMalUnUpdate() {
    }

    @After("alTerminarMetodoUpdate()")
    void aftereAdviceMethodAll() {
        logger.info("Se ejecutó el after advice luego de la ejecución del método con o sin excepcion");
    }

    @After("alTerminarMetodoDelete()")
    void aftereAdviceMethod() {
        logger.info("Se ejecutó el after advice luego de la ejecución del método con o sin excepcion");
    }

    @AfterThrowing("alTerminarHacerMalUnUpdate()")
    void afterThrowingAdviceMethod() {
        logger.info("Se ejecuto el after advice cuando hay una excepción en la ejecución de un método de la capa Controller");
    }
}