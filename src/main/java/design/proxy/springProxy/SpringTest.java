package design.proxy.springProxy;

import design.proxy.springAopDynamic.Math;

public class SpringTest {

    public static void main(String[] args) {
        new SpringTest().test();
    }

    private void test() {
        //从代理工厂中获得代理对象
        Math math =  new SpringProxy<Math>().getProxyObject(new Math());
        math.add(3, 3);
        math.sub(3, 3);
        math.mult(3, 3);
        math.div(3, 3);
    }
}
