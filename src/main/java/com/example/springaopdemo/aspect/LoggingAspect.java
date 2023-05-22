package com.example.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("@annotation(com.example.springaopdemo.annotation.AuditLog)")
    public void logPointcut(){
    }

    @Before("logPointcut()")
    public void logAllMethodCallsAdvice(JoinPoint joinPoint) {
        System.out.println("Log before running");
        System.out.println(joinPoint.getTarget().getClass().getName());
        System.out.println("hijacked..."+ joinPoint.getSignature().getName());
        System.out.println(Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList()));
        System.out.println("In Aspect");
    }


    @AfterThrowing(value = "execution(* com.example.springaopdemo.service.HelloService.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex)
    {
        System.out.println("After Throwing exception in method:"+joinPoint.getSignature());
        System.out.println("Exception is:"+ex.getMessage());
    }

    @AfterReturning(value = "execution(* com.example.springaopdemo.service.HelloService.*(..))", returning = "value")
    public  void afterReturningAdvice(JoinPoint joinPoint, Object value) {
        System.out.println("After Returing method:"+joinPoint.getSignature());
        System.out.println(value);
    }
}
