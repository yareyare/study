package design.proxyStatic;

/**
 * Created by ivy on 2017/3/17.
 */
public class Test {

    public static void main(String[] args) {
        //真实业务交给代理对象去处理
        Proxy proxy = new Proxy( new ConcreteSubject());
        proxy.request();
    }

}
