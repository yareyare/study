package thread.zxx.thread9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ivy on 2017/3/11.
 * 用BlockingQueue 实现线程互斥
 *
 * 一个满的队列queueFull（匿名构造中填满） 和一个空的队列queueEmpty
 * subThread 往空的队列queueEmpty放入
 * subThread 往满的队列queueFull取走
 * mainThread 往queueFull队列放入
 * mainThread 往queueEmpty队列取走
 */
public class BlockingQueueComunication2 {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    business.sub(10);

                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            business.main(5);

        }
    }

    static class Business {
        //自己管理自己的状态，不要让外面的线程去管
        BlockingQueue<Integer> queueEmpty = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> queueFull = new ArrayBlockingQueue<Integer>(1);

        {//匿名构造方法，在所有子类构造方法执行前执行
            try {
                queueFull.put(1);
                System.out.println("queueFull 满"+ queueFull.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public /*synchronized*/ void main(int n) {
            try {
                queueFull.put(1);
                System.out.println(Thread.currentThread().getName()+"queueFull 放入1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            for (int i = 1; i <= n; i++) {
//                System.out.println("主==" + i);
//            }
            try {
                queueEmpty.take();
                System.out.println(Thread.currentThread().getName()+"queueEmpty 取走1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public /*synchronized*/ void sub(int n) {
            try {
                queueEmpty.put(1);
                System.out.println(Thread.currentThread().getName()+"queueEmpty 放入1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            for (int i = 1; i <= n; i++) {
//                System.out.println("子" + i);
//            }

            try {
                queueFull.take();
                System.out.println(Thread.currentThread().getName()+"queueFull 取走1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

