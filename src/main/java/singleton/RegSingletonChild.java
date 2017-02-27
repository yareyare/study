package singleton;
/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午5:03:52 
 * @version 1.0  
 */
public class RegSingletonChild extends RegSingleton{
  //由于子类必须允许父类以构造方法调用产生实例，所以它的构造方法必须是公开的，protected或public  
    protected RegSingletonChild() {  
    }  
    //静态方法工厂  
    public static RegSingletonChild getInstance() {  
        return (RegSingletonChild) RegSingleton  
                .getInstance("com.chengshu.singleton.RegSingletonChild");  
    }  
}
