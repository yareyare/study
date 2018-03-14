package thread.mutiThread.WaitGtNotify;

/**
 * Created by admin on 2017/8/10.
 */
public class Subtract {
    public Object lock;

    public Subtract(Object lock){
        this.lock = lock;
    }

    public void subtract(){
        try {
            synchronized (lock){
                while(ValueObject.list.size()==0){
                //if(ValueObject.list.size()==0){
                    System.out.println("wait begin TN:"+Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end TN:"+Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size:"+ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
