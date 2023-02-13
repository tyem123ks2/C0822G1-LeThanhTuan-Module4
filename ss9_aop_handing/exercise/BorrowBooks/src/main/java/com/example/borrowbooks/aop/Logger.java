package com.example.borrowbooks.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    @Pointcut("execution(* com.example.borrowbooks.controller.BooksController.*Books(..))")
    public void callMethod(){

    }

    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("Bạn đã vào phương thức " + joinPoint.getSignature().getName() + ", lần" + LocalDateTime.now());
    }
}
