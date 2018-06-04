package thread.lockObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/7.
 */
public class MyList {

    private static List list = new ArrayList<>();

    public static void add(){
        list.add("something");
    }

    public static int size(){
        return list.size();
    }
}

class ThreadA extends Thread{

    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            synchronized (lock){
                if (MyList.size() != 5){
                    System.out.println("wait begin");
                    lock.wait();
                    System.out.println("wait end");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread{
    private Object lock;

    public ThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                for (int i=0 ;i<10;i++){
                    MyList.add();
                    if (MyList.size() == 5){
                        lock.notify();
                        System.out.println("唤醒通知");
                    }
                    System.out.println("添加了"+(i+1)+"个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Run{
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        threadB.start();
    }
}