package design.singleton;

import java.io.Serializable;

/**
 * Created by ivy on 2017/2/24.
 *
 * 如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。
 * 不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
 */
public class SerializableSingleton implements Serializable{

    public static SerializableSingleton INSTANCE = new SerializableSingleton();

    protected SerializableSingleton() {

    }
    private Object readResolve() {
        return INSTANCE;
    }
}
