package thread.zxx.thread6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ivy on 2017/3/11.
 */
public class ThreadPoolFirst {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newSingleThreadExecutor();//如何实现线程死了以后重新启动
        for (int i = 1; i <= 10; i++) {
            final int task = i ;
            pool.execute(new Runnable() {
                @Override
                public void run() {

                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " " + task);
                    }
                }
            });
        }
        pool.shutdown();


        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行");
            }
        },10, TimeUnit.SECONDS); //10秒后执行

        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行");
            }
        },5,2,TimeUnit.SECONDS);
    }
}
