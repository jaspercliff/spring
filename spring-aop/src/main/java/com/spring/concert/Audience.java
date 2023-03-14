package com.spring.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {


    /**
     * execution(访问限定符 返回类型方法名 参数 异常）
     * execution(* concert.Performance.perform(..))类里面的perform方法
     * execution(* Performance.*(..))类performance的所有方法
     * execution(* *.*(..))表示所有的
     * 匹配指定包路径下所有类的方法：execution(* com.test.bean.*(..)) (不包含子包)
     * 匹配指定包路径下所有类的方法：execution(* com.test.bean..*(..))（包含包，子包的所有类）
     */
    @Pointcut("execution(* Performance.perform(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void silenceCellPhone(){
        System.out.println("silencing the phone");
    }
    @Before("pointCut()")
    public void takeSeat(){
        System.out.println("take the seat");
    }

    @AfterReturning("pointCut()")
    public void applause(){
        System.out.println("clap clap clap");
    }
    @AfterThrowing("pointCut()")
    public void demandRefund(){
        System.out.println("demanding fund");
    }

}
