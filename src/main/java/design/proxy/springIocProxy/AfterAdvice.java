package design.proxy.springIocProxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知
 */
public class AfterAdvice implements AfterReturningAdvice {

    /**
     * returnValue 返回值
     * method 被调用的方法
     * args 方法参数
     * target 被代理对象
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        Long spend = System.currentTimeMillis() - start;
        System.out.println("【springIocProxy】" + method.getName() + " 共用时" + spend);
    }
}
