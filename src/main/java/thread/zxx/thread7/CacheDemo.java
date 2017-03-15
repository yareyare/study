package thread.zxx.thread7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ivy on 2017/3/12.
 * 面试：实现一个缓存系统
 */
public class CacheDemo {

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    //my cache
    Map<String,Object> cache = new HashMap<String,Object>();

    public static void main(String[] args) {
        CacheDemo demo = new CacheDemo();
        System.out.println(demo.getData("a"));

    }

    //用synchronized 可以实现互斥
    public synchronized Object getData(String key){
        Object data = null;
        data =cache.get(key);
        if (data==null){
            data = "aaa";
            cache.put("a",data);
        }
        return data;
    }

    //用lock实现互斥
    public  Object getDataGood(String key){
        rwLock.readLock().lock();
        Object data = null;
        try {
            data = cache.get(key);
            if (data == null) {
                data = "aaa"; //数据库里去读
                cache.put("a", data); //放入缓存
            }
        }finally {
            rwLock.readLock().unlock();
        }
        return data;
    }

    //用lock实现和并发读 并且 读写互斥
    public  Object getDataGood1(String key){
        rwLock.readLock().lock();
        Object data = null;
        try {
            data = cache.get(key);
            if (data == null) {
                rwLock.readLock().unlock();
                rwLock.writeLock().lock();
                try {
                    if (data==null) {//防止多线程写
                        data = "aaa";
                    }
                    cache.put("a", data);
                }finally {
                    rwLock.writeLock().unlock();
                }
            }
        }finally {
            rwLock.readLock().unlock();
        }
        return data;
    }
}
