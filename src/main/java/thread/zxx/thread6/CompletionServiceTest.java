package thread.zxx.thread6;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ivy on 2017/3/12.
 * CompletionService 可以返回多个线程的结果
 */
public class CompletionServiceTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletionService service = new ExecutorCompletionService(pool);
        for (int i=1;i<=10;i++) {
            final int seq = i;
            service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    try {
                        Thread.sleep(new Random().nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return seq;
                }
            });
        }

        for (int i=0;i<10;i++){
            try {
                System.out.println(service.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
