package design.singleton;

/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午3:42:42
 * @version 1.0
 *
 * 描述： 饿汉 变种
 * 表面上看起来差别挺大，其实跟SingletonHungry方式差不多，都是在类初始化即实例化instance。
 */

public class SingletonHungryChenged {

    private static SingletonHungryChenged instance = null;

    static {
        instance = new SingletonHungryChenged();
    }

    private SingletonHungryChenged() {
    }

    public static SingletonHungryChenged getInstance() {
        return instance;
    }
}