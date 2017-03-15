package thread.BankingScheduling;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ivy on 2017/3/14.
 * 模拟用户排队业务
 */
public class CustomerQueue {

    final static BlockingQueue<Customer> vipQueue = new ArrayBlockingQueue<Customer>(100);
    final static BlockingQueue<Customer> quickQueue = new ArrayBlockingQueue<Customer>(100);
    final static BlockingQueue<Customer> domesticQueue = new ArrayBlockingQueue<Customer>(100);

    public synchronized static Customer getVipCustomer() {
        Customer c = null;
        if (vipQueue.size() > 0) {
            try {
                c = vipQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                domesticQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public synchronized static Customer getQuickCustomer() {
        Customer c = null;
        if (quickQueue.size() > 0) {
            try {
                c = quickQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                domesticQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public synchronized static Customer getDomesticCustomer() {
        Customer c = null;
        try {
            c = domesticQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }


    public synchronized static BlockingQueue<Customer> getQuickQueue() {
        return quickQueue;
    }

    public synchronized static BlockingQueue<Customer> getDomesticQueue() {
        return domesticQueue;
    }

    public static void customerQueue() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long random = (long) (Math.random() * 1000);
                    try {
                        Thread.sleep(random);
                        Customer c = new Customer(random, BusinessType.DOMESTIC.name());
                        domesticQueue.put(c);
                        c = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long random = (long) (Math.random() * 1000);
                    try {
                        Thread.sleep(random);
                        Customer c = new Customer(random, BusinessType.VIP.name());
                        vipQueue.put(c);
                        c = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long random = (long) (Math.random() * 1000);
                    try {
                        Thread.sleep(random);
                        Customer c = new Customer(random, BusinessType.QUICK.name());
                        quickQueue.put(c);
                        c = null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
