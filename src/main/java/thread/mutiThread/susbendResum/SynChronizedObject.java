package thread.mutiThread.susbendResum;

/**
 * Created by admin on 2017/8/3.
 */
public class SynChronizedObject {

    synchronized public void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a 线程永远 suspend 了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

class Runner{
    public static void main(String[] args) {
        try {
            final SynChronizedObject object = new SynChronizedObject();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            thread1.sleep(1000);

            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    //object.printString();
                    System.out.println("thread2 启动了，但进入不了pringString() 方法，只打印一个begin");
                    System.out.println("因为pringString()方法被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.setName("b");
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
