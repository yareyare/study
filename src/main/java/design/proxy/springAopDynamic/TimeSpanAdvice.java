package design.proxy.springAopDynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 在Test的示例中如果要代理不同的对象需要反复创建ProxyFactory对象，代码会冗余。同样以实现方法耗时为示例代码如下：
 */
public class TimeSpanAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 被织入的横切内容，开始时间 before
        long start = System.currentTimeMillis();

        Object result = invocation.proceed();

        // 被织入的横切内容，结束时间
        long span  = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }
}
