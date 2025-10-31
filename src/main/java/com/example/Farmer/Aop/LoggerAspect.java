package com.example.Farmer.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    // Pointcut covering all major controller methods
    @Before("execution(* com.example.Farmer.controller.FarmerController.*(..))")
    public void methodCalling(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        // Get the authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (auth != null) ? auth.getName() : "Anonymous";

        if (args.length > 0) {
            log.info("User '{}' called method '{}' with arguments: {}", username, methodName, Arrays.toString(args));
        } else {
            log.info("User '{}' called method '{}' with no arguments", username, methodName);
        }
    }

    @After("execution(* com.example.Farmer.controller.FarmerController.*(..))")
    public void methodExecuted(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        // Get the authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (auth != null) ? auth.getName() : "Anonymous";

        if (args.length > 0) {
            log.info("User '{}' executed method '{}' with arguments: {}", username, methodName, Arrays.toString(args));
        } else {
            log.info("User '{}' executed method '{}' with no arguments", username, methodName);
        }
    }
}
