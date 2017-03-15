package thread.zxx.test.test2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ivy on 2017/3/13.
 * 使用线程安全的有序的队列，线程按顺序执行就使用信号量
 */
public class TestOK {
    public static void main(String[] args) {
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));

        final Semaphore semaphore = new Semaphore(1);
//        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String input = null;

                        semaphore.acquire();
                        input = queue.take();

                        String output = TestDo1.doSome(input);
                        System.out.println(Thread.currentThread().getName() + ":" + output);

                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        for (int i = 0; i < 10; i++) {  //这行不能改动
            String input = i + "";  //这行不能改动
            try {
                queue.put(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            String output = TestDo1.doSome(input);
//            System.out.println(Thread.currentThread().getName() + ":" + output);
        }
    }
}

//不能改动此TestDo类
class TestDo1 {
    public static String doSome(String input) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + " : " + (System.currentTimeMillis() / 1000);
        return output;
    }
}