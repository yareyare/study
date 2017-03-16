package thread.zxx.thread8;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ivy on 2017/3/12.
 * CyclicBarrier
 * 允许一组线程互相等待，直到到达某个公共屏障点(common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，
 * 此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier
 *
 * 实例：比如有3个人要一起去做一件事，在别人到达之前自己都是等待状态，3个人到齐以后才能做事情
 */
public class CyclicBarrierTest {
    private static final Integer COUNT = 3;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT);

        for (int i = 0; i < COUNT; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + "到达集合点1，当前已有" + (cyclicBarrier.getNumberWaiting() + 1));
                        System.out.println( cyclicBarrier.getNumberWaiting()==2?"去集合点2":"等待中......");
                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + "到达集合点2，当前已有" + (cyclicBarrier.getNumberWaiting() + 1));
                        System.out.println( cyclicBarrier.getNumberWaiting()==2?"去集合点3":"等待中......");
                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread().getName() + "到达集合点3，当前已有" + (cyclicBarrier.getNumberWaiting() + 1));
                        System.out.println( cyclicBarrier.getNumberWaiting()==2?"到达终点":"等待中......");
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        cyclicBarrier.reset();
                    }
                }
            };
            pool.execute(r);
        }
    }
}
