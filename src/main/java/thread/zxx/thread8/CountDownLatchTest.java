package thread.zxx.thread8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ivy on 2017/3/12.
 * 3个运动员就位，等待指令
 *
 * 裁判看到3个运动员都就位
 * 发布指令
 *
 * 3个运动员纷纷收到指令，赛跑
 *
 * 教练检查3个运动员纷纷跑完，公布结果
 *
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);

        for (int i=0;i<3;i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在准备接收命令......");
                        cdOrder.await();

                        System.out.println(Thread.currentThread().getName() + "已经接收到命令");

                        Thread.sleep(2000);

                        System.out.println(Thread.currentThread().getName() + "回应命令处理结果");

                        cdAnswer.countDown();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            pool.execute(runnable);
        }


        //主线程执行
        try {
            Thread.sleep((long) Math.random()*100000);
            System.out.println(Thread.currentThread().getName()+"即将发出命令");

            cdOrder.countDown();
            System.out.println(Thread.currentThread().getName()+"发出命令，等待相应结果");

            cdAnswer.countDown();
            System.out.println(Thread.currentThread().getName()+"已收到相应结果");
        }catch (Exception e){

        }
    }
}
