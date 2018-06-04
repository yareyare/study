package thread.mutiThread.productCustom.oneToOne;

/**
 * Created by admin on 2017/8/10.
 */
public class Run {

    public static void main(String[] args) {
        Object lock = new Object();
        P p = new P(lock);
        C c = new C(lock);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);

        threadP.start();
        threadC.start();
    }
}

/**
 * 实现了一个生产者和一个消费者进行数据交互
 * set值 和 get值 的操作是成对出现的
 * */