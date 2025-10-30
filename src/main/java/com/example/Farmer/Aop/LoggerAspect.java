// package com.example.Farmer.Aop;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;

// @Component
// @Aspect
// public class LoggerAspect {

//     private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

//     // return type clasname.methodname(args)
//     @Before("execution(* com.example.Farmer.controller.FarmerController.addFarmer(..)) || execution(* com.example.Farmer.controller.FarmerController.getAllFarmers(..)) || execution(* com.example.Farmer.controller.FarmerController.getFarmerById(..)) || execution(* com.example.Farmer.controller.FarmerController.deletefarmer(..)) || execution(* com.example.Farmer.controller.FarmerController.updateFarmer(..)) || execution(* com.example.Farmer.controller.FarmerController.partialUpdate(..)) || execution(* com.example.Farmer.controller.FarmerController.getFarmersByName(..)) || execution(* com.example.Farmer.controller.FarmerController.getFarmersByFarmingType(..))|| execution(* com.example.Farmer.controller.FarmerController.getAllFarmersCustom(..)) || execution(* com.example.Farmer.controller.FarmerController.getFarmerByIdCustom(..))")
//     public void methodCalling(JoinPoint jp) {
//         log.info(jp.getSignature().getName() + " is called");
//     }

// }




























package com.example.Farmer.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    // Pointcut for all controller methods you want to log
    @Before("execution(* com.example.Farmer.controller.FarmerController.addFarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getAllFarmers(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmerById(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.deletefarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.updateFarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.partialUpdate(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmersByName(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmersByFarmingType(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getAllFarmersCustom(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmerByIdCustom(..))")
    public void methodCalling(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs(); // All input arguments

        // Log method name and arguments
        if (args.length > 0) {
            log.info("Method '{}' called with arguments: {}", methodName, Arrays.toString(args));
        } else {
            log.info("Method '{}' called with no arguments", methodName);
        }
    }

     @After("execution(* com.example.Farmer.controller.FarmerController.addFarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getAllFarmers(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmerById(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.deletefarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.updateFarmer(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.partialUpdate(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmersByName(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmersByFarmingType(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getAllFarmersCustom(..)) || " +
            "execution(* com.example.Farmer.controller.FarmerController.getFarmerByIdCustom(..))")
    public void methodexecution(JoinPoint jp) {

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs(); // All input arguments

        // Log method name and arguments
        if (args.length > 0) {
            log.info("Method '{}' executed with arguments: {}", methodName, Arrays.toString(args));
        } else {
            log.info("Method '{}' executed with no arguments", methodName);
        }
    }
}

