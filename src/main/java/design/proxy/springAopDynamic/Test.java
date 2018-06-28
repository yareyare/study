package design.proxy.springAopDynamic;

import design.proxy.proxyDynamicJDK.IMath;
import org.springframework.aop.framework.ProxyFactory;

public class Test {

    public static void main(String[] args) {
        Test.test();
    }

    private static void test() {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new Math());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new AfterAdvice());
        factory.addAdvice(new SurroundAdvice());
        //从代理工厂中获得代理对象
        IMath math  = (IMath)factory.getProxy();
        math.add(2,2);
        math.sub(2,2);
        math.mult(2,2);
        math.div(2,2);
    }
}
