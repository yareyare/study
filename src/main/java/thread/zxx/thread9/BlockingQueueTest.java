package thread.zxx.thread9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ivy on 2017/3/12.
 * Lock 的辅助类 Conditiong 的api文档里有一个阻塞队列的实现
 * 然而javaApi里原本就有一个直接可以用的队列，它就是ArrayBlockingQueue
 * 队列空的时候，取数据线程等待，队列满的时候写数据线程等待
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(3);   //容量为3的队列
        for (int i = 1; i <= 1; i++) {
            final Integer c = i;
            Thread t = new Thread() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep(6000);
                            System.out.println(Thread.currentThread().getName() + " 准备放数据" + c);
                            queue.put(c);
                            System.out.println(Thread.currentThread().getName() + " 数据已经放入");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();



            Thread t1 = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 准备取数据");
                            Thread.sleep(1000);
                            Integer result = (Integer) queue.take();
                            System.out.println(Thread.currentThread().getName() + " 取到数据" + result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
        }
    }
}
