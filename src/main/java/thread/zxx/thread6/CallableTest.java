package thread.zxx.thread6;

import java.util.concurrent.*;

/**
 * Created by ivy on 2017/3/12.
 * Callable 和 Future 的使用
 * 能接受线程返回结果，也能捕获线程执行中抛出的异常
 */
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(new Callable<String>(
        ) {
            @Override
            public String call() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello";
            }
        });

        try {
            System.out.println("获取到结果"+future.get(1,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
