package singleton;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午3:42:42
 * @version 1.0
 *
 * 描述： 懒汉 线程安全
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步。
 */

public class LazySysSingleton {

    private static LazySysSingleton singleton = null;

    // 私有的默认构造方法，此类不能被继承
    private LazySysSingleton() {
    }

    // 同步，静态工厂方法，返回此类的唯一实例
    public synchronized static LazySysSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySysSingleton();
        }
        return singleton;
    }
}
