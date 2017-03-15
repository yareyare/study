package thread.zxx.thread8;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ivy on 2017/3/12.
 * Semaphore 可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数，
 * 例如一个文件允许的并发访问数
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3, true);//线程池共用3个信号量



        for (int i=0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+"进入,当前有" +(3-semaphore.availablePermits()));

                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"已离开,当前有" +(3-semaphore.availablePermits())+"个并发");
                }
            };
            pool.execute(runnable);
        }


    }
}
