package singleton;


/**
 * @author 张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午3:42:42
 * @version 1.0
 *
 * 描述： 懒汉
 * 这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 */

public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton(){}

    public static LazySingleton getSingleton(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
