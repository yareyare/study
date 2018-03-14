package thread.mutiThread.productCustom.WaitingDeath;

/**
 * Created by admin on 2017/8/10.
 */
public class Run {

    public static void main(String[] args) {
        Object lock = "";
        P p = new P(lock);
        C c = new C(lock);

        ThreadP[] threadPs = new ThreadP[2];
        ThreadC[] threadCs = new ThreadC[2];

        for (int i = 0 ;i<=1;i++) {
            threadPs[i] = new ThreadP(p);
            threadPs[i].setName("生产者-" + i);
            threadCs[i] = new ThreadC(c);
            threadCs[i].setName("消费者-"+i);
            threadPs[i].start();
            threadCs[i].start();
        }
        try { Thread.sleep(50000);} catch (InterruptedException e) {e.printStackTrace(); }

        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0 ;i <threadArray.length;i++){
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
        }
    }
}

/**
 * 多个生产者和多个消费者进行数据交互
 * 出现假死
 *
 * 解决这种假死的方法就是把notify 改成notifyAll
 * */