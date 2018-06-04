package thread.mutiThread.productCustom.OneToMany;

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
                if(ValueObject.list.size()!=0){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是："+value);
                ValueObject.list.add(value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
