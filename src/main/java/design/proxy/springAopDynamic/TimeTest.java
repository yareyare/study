package design.proxy.springAopDynamic;

import design.proxy.proxyDynamicJDK.IMath;

public class TimeTest {

    public static void main(String[] args) {
        new TimeTest().test();
    }

    private void test() {
        //从代理工厂中获得代理对象
        IMath math = (IMath) TimeDynamicProxy.getProxy(new Math());
        math.add(3, 3);
        math.sub(3, 3);
        math.mult(3, 3);
        math.div(3, 3);
    }

}
