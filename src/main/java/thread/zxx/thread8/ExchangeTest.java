package thread.zxx.thread8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ivy on 2017/3/12.
 * Exchange 用于两个用户之间交换数据，每个人在完成一个事务后想与对方交换数据，
 * 第一个先先拿到数据的人将等待第二个人拿着数据到来时，彼此才能交换数据
 * <p>
 * 实例  ： 卖毒粉
 */
public class ExchangeTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        final Exchanger exchanger = new Exchanger();

        Runnable buyer = new Runnable() {
            @Override
            public void run() {
                try {
                    String baimian = "300g白面";
                    System.out.println(Thread.currentThread().getName()+"我来卖白面了，我有："+baimian);

                    Thread.sleep(3000);

                    Double money = (Double) exchanger.exchange(baimian);

                    System.out.println(Thread.currentThread().getName()+"白面已卖出，收益" + money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        pool.execute(buyer);
        Runnable du = new Runnable() {
            @Override
            public void run() {
                try {
                    Double money = 500000.0d;
                    System.out.println(Thread.currentThread().getName()+"我来买白面了,我有"+money+"¥");
                    Thread.sleep(3000);

                    String baimian = (String) exchanger.exchange(money);

                    System.out.println(Thread.currentThread().getName()+"白面已买到:" +baimian);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        pool.execute(du);
    }
}
