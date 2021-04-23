package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderFacadeAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspect.class);

    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
                "&& target(object)")
    void logExecution(JoinPoint joinPoint, Object object){
        LOGGER.info("Class: " + object.getClass().getName() + ": running " + joinPoint.getSignature().getName() );
    }

    @After(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& target(object)")
    void logFinished(JoinPoint joinPoint, Object object){
        LOGGER.info("Class: " + object.getClass().getName() + ": " +joinPoint.getSignature().getName()
                + " finished.");
    }

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& target(object)", throwing = "error")
    void logError(JoinPoint joinPoint, Object object, Throwable error){
        LOGGER.info("Class: " + object.getClass().getName() + ": " +joinPoint.getSignature().getName());
        LOGGER.error("Exception: " + error);
    }
}
