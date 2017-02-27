package singleton;
/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午2:35:59 
 * @version 1.0
 *
 * 描述：饿汉式
 * 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用getInstance方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化instance显然没有达到lazy loading的效果。
 */

//饿汉式

public class SingletonHungry {
    private final static SingletonHungry singletone = new SingletonHungry();
    
    private SingletonHungry(){}
    
    // 务必使用static声明为类所属方法
    public static SingletonHungry getInstance(){
        return singletone;
    }
}