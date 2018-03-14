package thread.mutiThread.productCustom.WaitingDeath;

import thread.mutiThread.WaitGtNotify.ValueObject;

/**
 * Created by admin on 2017/8/10.
 */
public class P {

    public Object lock;

    public P(Object lock){
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                while(ValueObject.list.size()!=0){
                    System.out.println("生产者："+Thread.currentThread().getName()+"waiting***");
                    lock.wait();
                }
                System.out.println("生产者："+Thread.currentThread().getName()+"running***");

                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                ValueObject.list.add(value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
