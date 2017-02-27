package singleton;
/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午3:44:18 
 * @version 1.0
 *
 * 描述:双重校验锁
 *
 * 在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 */
public class DoubleCheckSingleton {
    //volatile 关键字，jvm优化时不改变这条语句
    private volatile static DoubleCheckSingleton singleton = null;  
    
    // 私有的默认构造方法，此类不能被继承  
    private DoubleCheckSingleton() {  
    }  
  
    // 静态工厂方法，返回此类的唯一实例  
    public static DoubleCheckSingleton getInstance() {  
        if (singleton == null) {  
            synchronized (DoubleCheckSingleton.class) {  
                if (singleton == null) {  
                    singleton = new DoubleCheckSingleton();  
                }  
            }  
        }  
        return singleton;  
    }  
}
