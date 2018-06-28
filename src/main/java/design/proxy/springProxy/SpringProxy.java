package design.proxy.springProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class SpringProxy<T> implements MethodInterceptor {
    /**获得代理后的对象*/
    public T getProxyObject(Object target){
        //代理工厂
        ProxyFactory proxy=new ProxyFactory();
        //添加被代理的对象
        proxy.setTarget(target);
        //添加环绕通知
        proxy.addAdvice(this);
        //获得代理后的对象
        return (T) proxy.getProxy();
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        //调用方法获得结果
        Object result=methodInvocation.proceed();
        after(result);
        return result;
    }

    public void before(){
        System.out.println("调用方法前");
    }
    public void after(Object result){
        System.out.println("调用方法后"+result);
    }
}
