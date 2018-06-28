package design.proxy.springIocProxy;

import design.proxy.proxyDynamicJDK.IMath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        new Test().test();
    }

    public void test()
    {
        //容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        //从代理工厂中获得代理对象
        IMath math=(IMath)ctx.getBean("proxy");
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mult(n1, n2);
        math.div(n1, n2);
    }
}
