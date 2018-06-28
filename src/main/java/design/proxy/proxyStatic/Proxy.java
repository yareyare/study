package design.proxy.proxyStatic;

/**
 * Created by ivy on 2017/3/17.
 */
public class Proxy implements Subject {

    //要代理哪个实现类
    private Subject subject = null;

    //默认被代理者
    public Proxy(Subject subject){
        this.subject = subject;
    }


    //实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    //预处理
    private void before(){
        System.out.println("before");
    }

    //善后处理
    private void after(){
        System.out.println("after");
    }
}


/*
优点
        1.       职责清晰   真实的角色就是实现的业务逻辑，不用关心其他非本职责的事务
        2.       高扩展性   具体主题角色不能怎么变化，只要它实现了接口，代理类完全可以在不做任何修改的情况下使用
        3.       智能化     动态代理是最好的体现，即在运行阶段才指定实际代理对象(Struts如何把表单元素映射到对象上?)
        使用场景   典型应用如spring AOP
        扩展
        1.       普通代理    要求客户端只能访问代理角色，而不能访问真实角色
        2.       强制代理    要求客户端必须通过真实角色找到代理角色(演员和经纪人)
        3.       虚拟代理    指在需要的时候，才初始化主题对象,可以避免被代理对象太多而引起的初始化缓慢问题
*/