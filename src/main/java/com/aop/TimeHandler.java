package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class TimeHandler {

    public void before(JoinPoint point)
    {
        String methodStr =  point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName();
        System.out.println("AOP before CurrentTime = " + System.currentTimeMillis()+
                ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                ";被织入的目标对象为：" + point.getTarget());
    }

    public void after(JoinPoint point)
    {
        String methodStr =  point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName();
        System.out.println("AOP after CurrentTime = " + System.currentTimeMillis()+
                ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                ";被织入的目标对象为：" + point.getTarget());
    }

    public Object around(ProceedingJoinPoint point){
        try {
            String methodStr =  point.getSignature().getDeclaringTypeName() +
                    "." + point.getSignature().getName();
            System.out.println("AOP around 开始执行前;CurrentTime = " + System.currentTimeMillis()+
                    ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                    ";被织入的目标对象为：" + point.getTarget());
            Object result = point.proceed();
            System.out.println("AOP around result="+result+";CurrentTime = " + System.currentTimeMillis()+
                    ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                    ";被织入的目标对象为：" + point.getTarget());
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public void afterReturning(JoinPoint point)
    {
        String methodStr =  point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName();
        System.out.println("AOP afterReturning CurrentTime = " + System.currentTimeMillis()+
                ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                ";被织入的目标对象为：" + point.getTarget());
    }

    public void afterThrowing(JoinPoint point)
    {
        String methodStr =  point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName();
        System.out.println("AOP afterThrowing CurrentTime = " + System.currentTimeMillis()+
                ";目标方法为"+methodStr+";参数为：" + Arrays.toString(point.getArgs()) +
                ";被织入的目标对象为：" + point.getTarget());
    }
}
