package thread.zxx.thread7;

import sun.misc.ConditionLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ivy on 2017/3/11.
 * 用lock&Condition实现主线程和子线程的交互
 * Condition 是基于Lock来使用的。应用时要绑定到Lock对象上
 * Condition的await() 相当于Object 的wati()
 * Condition的signal() 相当于Object的notify()
 *
 * 附加：Condition的Api中实现里一个阻塞队列 class BoundedBuffer
 */
public class ConditionComunication2 {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    business.sub(10);

                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            business.main(5);

        }
    }


    static class Business {
        Lock lock = new ReentrantLock();
        Condition conditionLock = lock.newCondition();
        private boolean subRun = true;

        public /*synchronized*/ void main(int n) {
            lock.lock();
            try {
                while (subRun) {  //这里用while比用if好，可以防止为唤醒。看wait的Api
                    try {
                        //this.wait();
                        conditionLock.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("主==" + i);
                }
                subRun = true;
//                this.notify();
                conditionLock.signal();
            } finally {
                lock.unlock();
            }
        }

        public /*synchronized*/ void sub(int n) {
            lock.lock();
            try {

                while (!subRun) {
                    try {
                        //this.wait();
                        conditionLock.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("子" + i);
                }
                subRun = false;
                //this.notify();
                conditionLock.signal();
            }finally {
                lock.unlock();
            }
        }
    }

}

