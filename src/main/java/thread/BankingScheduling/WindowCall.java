package thread.BankingScheduling;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ivy on 2017/3/14.
 */
public class WindowCall {

    static final Semaphore vipSem = new Semaphore(1, true);
    static final Semaphore quickSem = new Semaphore(1, true);
    static final Semaphore domesticSem = new Semaphore(1, true);

    public static void callVip(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Window.vip(CustomerQueue.getVipCustomer());
                }
            }
        }).start();
    }

    public static void callQuick(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Window.quick(CustomerQueue.getQuickCustomer());
                }
            }
        }).start();
    }

    public static void callDomestic(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Window.domenstic(CustomerQueue.getDomesticCustomer());
                }
            }
        }).start();
    }


}
