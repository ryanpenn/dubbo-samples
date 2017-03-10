package cn.ryanpenn.dubbo.samples.sample.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * MethodInvokeAop
 */
public class MethodInvokeAop {
    public void doBefore(JoinPoint jp){
        System.out.println(jp.getSignature().toShortString() + " 方法被调用了.");
    }

    public void doAfter(JoinPoint jp){

    }

    public void doAround(ProceedingJoinPoint pjp) throws Throwable{
        pjp.proceed();
    }

    public void doAfterReturning(Object value){

    }

    public void doAfterThrowing(Throwable ex){

    }
}
