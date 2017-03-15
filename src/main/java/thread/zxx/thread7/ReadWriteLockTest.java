package thread.zxx.thread7;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ivy on 2017/3/12.
 * 读写锁
 * 读写锁：分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，写锁与写锁互斥，这是有JVM控制的，应用时只需要控制好锁就可以了
 *
 * 面试题：实现一个缓存
 *
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        Queue1 q = new Queue1();

        for (int i=0 ;i<3;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    q.get();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    q.put();
                }
            }).start();
        }
    }

}


class Queue1{
    private static Integer data = 0;
    private static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    public static void get(){
        rwlock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" 准备读");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" 准备读"+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }
    }

    public void put(){
        rwlock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" 准备写");
            Thread.sleep(10000);
            data = new Random().nextInt();
            System.out.println(Thread.currentThread().getName()+" 准备写"+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }
    }
}
