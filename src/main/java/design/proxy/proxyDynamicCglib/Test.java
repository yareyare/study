package design.proxy.proxyDynamicCglib;

public class Test {

    //实例化一个MathProxy代理对象
    //通过getProxyObject方法获得被代理后的对象
    public static void main(String[] args) {
        Math math = (Math) new DynamicProxy().getProxyObject(new Math());
        math.add(1, 1);
        math.sub(1, 1);
        math.mult(1, 1);
        math.div(1, 1);
    }
}
