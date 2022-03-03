package com.onisun.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Neo
 * @version 1.0
 */
@Component
@Aspect   //将该类设置为切面类
public class LogUtil {
    /*
     *@Before 在目标方法之前运行，前置通知
     *@AfterReturning 在目标方法正常返回之后执行 返回通知
     * @AfterThrowing 在目标方法抛出异常后执行 异常通知
     * @After 在目标方法之后运行，后置通知
     * @Around 环绕通知
     *
     */
/*

    @Before("execution(public int com.onisun.service.impl.CalcImpl.*(int ,int))")
    public static void start(){
        System.out.println("方法开始执行，使用的参数是：");
    }

    @After("execution(public int com.onisun.service.impl.CalcImpl.*(int,int))")
    public static void end(){
        System.out.println("方法执行结束了......");
    }

    @AfterReturning("execution(public int com.onisun.service.impl.CalcImpl.*(int,int))")
    public static void stop(){
        System.out.println("方法执行结束，结果是：");
    }

    @AfterThrowing("execution(public int com.onisun.service.impl.CalcImpl.*(int,int))")
    public static void logException(){
        System.out.println("方法出现异常：");
    }
*/

    @Pointcut("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    public void myPointCut(){

    }

//    @Before("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    @Before("myPointCut()")
    public static void start(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法开始执行：参数是" + Arrays.asList(args));
    }

    @AfterReturning(value = "execution( public Integer com.onisun.service.impl.CalcImpl.*(..))",returning = "result" )
    public static void stop(JoinPoint joinPoint,int result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法执行结束，结果是：" + result);
    }

    @AfterThrowing("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    public static void logException(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法抛出异常：");
    }

    @After("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    public static void logFinally(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法执行结束。。。。。over");

    }



}
