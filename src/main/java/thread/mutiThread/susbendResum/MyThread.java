package thread.mutiThread.susbendResum;

/**
 * Created by admin on 2017/8/3.
 */
public class MyThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
            while (true){
                //i++;
                System.out.println(i++);
            }
    }
}

class Runner1{
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.sleep(1000);
        thread.suspend();//
        System.out.println("+++++++++++++++++++++++++++main end");
    }
}

/**
 * 当不执行System.out.println(i++)的情况下 thread.suspend()能够让子线程停止运行
 * 当程序运行到pringln()方法内部停止时，同步锁未被释放。子线程不会结束
 * synchronized (this) {
        print(x);
        newLine();
   }
 * **/