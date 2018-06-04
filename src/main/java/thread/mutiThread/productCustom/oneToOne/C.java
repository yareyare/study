package thread.mutiThread.productCustom.oneToOne;

import thread.mutiThread.WaitGtNotify.*;
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
                if (ValueObject.list.size() == 0) {
                    lock.wait();
                }
                System.out.println("get 到值：" + ValueObject.list.get(0));
                ValueObject.list.remove(0);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
