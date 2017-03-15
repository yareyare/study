package thread.zxx.thread7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ivy on 2017/3/11.
 * 两个线程同时运行
 */
public class LockTest {
    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init() {
        Outputer out = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.outPut("zhangyan");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.outPut("wanganshi");
                }
            }
        }).start();
    }


    class Outputer {

        //对name同步是不行,对x进行同步是可以实现互斥的
        String x = "";

        private synchronized void outPut(String name) {
            synchronized (x) {  // 或者 synchronized (this)
                int lenth = name.length();
                for (int i = 0; i < lenth; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        //方法上加锁是可以实现互斥的
        private synchronized void outPut2(String name) {
            int lenth = name.length();
            for (int i = 0; i < lenth; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }


    static class OutputerStatic {
        Lock lock = new ReentrantLock();
        //对name同步是不行,对x进行同步是可以实现互斥的
        String x = "";

        private synchronized void outPut(String name) {

//            synchronized (OutputerStatic.class) { //*******  静态类对x 或者this 同步，也不能达到线程互斥的效果，要对字节码文件进行加锁
            lock.lock();
            try {
                int lenth = name.length();
                for (int i = 0; i < lenth; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }finally {
                lock.unlock();
            }
        }

        //方法上加锁是可以实现互斥的
        private synchronized void outPut2(String name) {
            int lenth = name.length();
            for (int i = 0; i < lenth; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        // 这里添加static修饰，则类也要加static修饰
        // 静态方法outPut3要与outPut1或者output2互斥，则需要对字节码文件进行加锁
        private static synchronized void outPut3(String name) {
            int lenth = name.length();
            for (int i = 0; i < lenth; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}
