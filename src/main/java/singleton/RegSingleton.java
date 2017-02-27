package singleton;

import java.util.HashMap;

/** 
 * @author  张彦
 * @email: zhangyan1@juxinli.com
 * @date 创建时间：2016年11月21日 下午3:45:47 
 * @version 1.0  
 */

//登记式单例类是为了克服饿汉式单例类和懒汉式单例类不可继承的缺点而设计的。   
public class RegSingleton {
    private static HashMap<String,Object> registry=new HashMap<String,Object>(); 
    
    /**静态代码块 
     * 静态代码块优先于主方法执行，而在类中定义的静态代码会优先于构造块执行，而且不管产生多少对象，静态代码块只执行一次。                                                                                
     */  
    static {
        RegSingleton singleton = new RegSingleton();
        registry.put(singleton.getClass().getName(), singleton);
    }
    
    protected RegSingleton() {    }
    
    public static RegSingleton getInstance(String name){  
        if(name==null){  
            name="singleton.RegSingleton";
        }
        if(registry.get(name)==null){  
            try {  
                registry.put(name, Class.forName(name).newInstance());  
            } catch (InstantiationException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IllegalAccessException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (ClassNotFoundException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        return (RegSingleton) registry.get(name);  
    }  
}
