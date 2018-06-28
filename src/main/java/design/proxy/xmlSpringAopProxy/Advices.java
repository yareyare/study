package design.proxy.xmlSpringAopProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advices {

    //前置通知
    public void before(JoinPoint jp)
    {
        System.out.println("【bofore】"+jp.getSignature().getName()+"----------------------------------------");
        //System.out.println("方法名："+jp.getSignature()+"，参数："+jp.getArgs().length+"，代理对象："+jp.getTarget());
    }
    //后置通知
    public void after(JoinPoint jp){
        System.out.println("【after】"+jp.getSignature().getName()+"----------------------------------------");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint pjd) throws Throwable{
        System.out.println("【around】start："+pjd.getSignature().getName()+"----------------------------------------");
        Object object=pjd.proceed();
        System.out.println("【around】end："+pjd.getSignature().getName()+"----------------------------------------");
        return object;
    }
    //异常后通知
    public void afterThrowing(JoinPoint jp,Exception exp)
    {
        System.out.println("【afterThrowing】"+jp.getSignature().getName()+" 异常后通知，发生了异常："+exp.getMessage()+"--------------------");
    }
    //返回结果后通知
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        System.out.println("【afterReturning】"+joinPoint.getSignature().getName()+"----------------------------------------result="+result);
    }
}
