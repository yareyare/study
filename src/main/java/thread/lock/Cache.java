package thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ivy on 2017/3/9.
 * 用map做一个缓存
 * 使用了一个非线程安全的HashMap作为缓存的时候然后使用读写锁来保证线程安全。
 * Cache使用读写锁提升读操作的并发性，也保证每次写操作对读操作的及时可见性，同时简化了编程方式。
 */
public class Cache {
    private static Map<String, String> map = new HashMap<String, String>();
    private static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    static Lock rLock = rwlock.readLock();
    static Lock wLock = rwlock.writeLock();

    //获取一个key对应的value
    public static final String get(String key) {
        rLock.lock();
        try {
            return map.get(key);
        } finally {
            rLock.unlock();
        }
    }

    //设置key对应的value并返回旧的value
    public static final String put(String key,String value){
        wLock.lock();
        try{
            return map.put(key,value);
        }finally{
            wLock.unlock();
        }
    }

    //清理缓存
    public static final void clear(){
        wLock.lock();
        try {
            map.clear();
        }finally{
            wLock.unlock();
        }

    }

}
