package design.proxy.proxyDynamicCglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理类
 * 实现了一个方法拦截器接口
 */
public class DynamicProxy implements MethodInterceptor {

    //被代理对象
    Object targetObject;

    // 拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 被织入的横切内容，开始时间 before
        long start = System.currentTimeMillis();

        Object result = methodProxy.invoke(targetObject, args);

        // 被织入的横切内容，结束时间
         Long span = System.currentTimeMillis() - start;
        System.out.println("【cglib代理】"+method.getName() +"用时计算：" + span);
        return result;
    }

    //动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
    public Object getProxyObject(Object object){
        this.targetObject = object;
        // 增强器，动态代理生成器
        Enhancer enhancer = new Enhancer();
        // 回调方法
        enhancer.setCallback(this);
        // 设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());
        //动态生成字节码并返回代理对象
        Object o = enhancer.create();
        return o;
    }
}
