package design.proxy.xmlSpringAopProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        //容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beansOfAOP.xml");
        //从代理工厂中获得代理对象
        IMath math = (IMath) ctx.getBean("math");
        math.add(3, 3);
        math.sub(3, 3);
        math.mult(3, 3);
        try {
            math.div(3, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
