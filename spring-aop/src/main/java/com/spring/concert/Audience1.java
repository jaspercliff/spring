package com.spring.concert;

import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Getter
public class Audience1 {
    private int num;
    @Pointcut("execution(* Performance.perform(int))&&args(num)")
    public void pointCut(int num){}

    @Around("pointCut(num)")
    public void watchPerformance(ProceedingJoinPoint jp,int num){
        try {
            System.out.println("silence the phone");
            System.out.println("take the seat");
            jp.proceed(new Object[]{num});
            System.out.println("clap clap");
        } catch (Throwable e) {
            System.out.println("demanding refund");
            System.out.println(e.getMessage());
        }
    }

}
