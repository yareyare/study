package thread.mutiThread.WaitGtNotify;


/**
 * Created by admin on 2017/8/10.
 */
public class Add {
    private Object lock;
    public Add(Object lock){
        this.lock = lock;
    }
    public void add(){
        synchronized (lock){
            ValueObject.add();
            lock.notifyAll();
        }
    }

}
