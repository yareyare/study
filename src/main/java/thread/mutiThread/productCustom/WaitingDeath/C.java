package thread.mutiThread.productCustom.WaitingDeath;

import thread.mutiThread.WaitGtNotify.ValueObject;

/**
 * Created by admin on 2017/8/10.
 */
public class C {
    public Object lock;

    public C(Object lock){
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("消费者："+Thread.currentThread().getName()+"waiting---");
                    lock.wait();
                }
                System.out.println("消费者："+Thread.currentThread().getName()+"running---"+ValueObject.list.get(0));
                ValueObject.list.remove(0);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
