package thread.zxx.thread7;

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
public class ThreadConditionComunication2 {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    business.sub2(2);

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    business.sub3(2);

                }
            }
        }).start();

        for (int i = 0; i <6; i++) {
            business.main(3);

        }
    }


    static class Business {
        Lock lock = new ReentrantLock();
        Condition conditionLock1 = lock.newCondition();
        Condition conditionLock2 = lock.newCondition();
        Condition conditionLock3 = lock.newCondition();
        private Integer flag = 1; //1 表示该main执行，2表示该sub2执行，3表示该sub3执行

        public /*synchronized*/ void main(int n) {
            lock.lock();
            try {
                while (flag != 1) {  //这里用while比用if好，可以防止为唤醒。看wait的Api
                    try {
                        //this.wait();
                        conditionLock1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("主==" + i);
                }
                flag = 2;                //设置应该执行的状态
                conditionLock2.signal(); //通知该sub2执行了
            } finally {
                lock.unlock();
            }
        }

        public /*synchronized*/ void sub2(int n) {
            lock.lock();
            try {

                while (flag != 2) {
                    try {
                        //this.wait();
                        conditionLock2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("子2==" + i);
                }
                flag = 3;
                conditionLock3.signal(); //
            }finally {
                lock.unlock();
            }
        }

        public /*synchronized*/ void sub3(int n) {
            lock.lock();
            try {

                while (flag!=3) {
                    try {
                        //this.wait();
                        conditionLock3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= n; i++) {
                    System.out.println("子3==" + i);
                }
                 flag = 1;   //又该主程序执行了
                //this.notify();
                conditionLock1.signal();
            }finally {
                lock.unlock();
            }
        }
    }

}

