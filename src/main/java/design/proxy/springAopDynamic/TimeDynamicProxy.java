package design.proxy.springAopDynamic;

import org.springframework.aop.framework.ProxyFactory;

public abstract class TimeDynamicProxy {

    public static Object getProxy(Object object) {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(object);
        //添加通知，横切逻辑
        factory.addAdvice(new TimeSpanAdvice());
        return factory.getProxy();
    }
}
