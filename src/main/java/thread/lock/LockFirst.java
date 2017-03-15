package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ivy on 2017/3/9.
 */
public class LockFirst {
    private static int a = 1;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            System.out.println(a++);
        }catch (Exception e){

        }finally{
            lock.unlock();
        }

    }
}
