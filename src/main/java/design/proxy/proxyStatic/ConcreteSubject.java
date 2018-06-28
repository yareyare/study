package design.proxy.proxyStatic;

/**
 * Created by ivy on 2017/3/17.
 */
public class ConcreteSubject implements Subject {
    @Override
    public void request() {
        System.out.println("具体业务处理 。。。。");
    }
}
