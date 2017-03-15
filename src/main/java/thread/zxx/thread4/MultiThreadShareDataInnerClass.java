package thread.zxx.thread4;

/**
 * Created by ivy on 2017/3/11.
 * 将这些Runnable对象作为这个类的内部类，共享数据作为这个外部类中的成员变量，
 * 每个线程对这个共享数据的操作方法也分配给外部类，以便实现对共享数据进行的各个操作的互斥和通信，
 * 作为内部类的各个Runnable对象调用外部类的这些方法
 */
public class MultiThreadShareDataInnerClass {

    private static ShareData shareData ;
    public static void main(String[] args) {
        final ShareData1 shareData = new ShareData1();
        new Thread(new MyRunnable1(shareData)).start();
        new Thread(new MyRunnable2(shareData)).start();
    }
}


class MyRunnable11 implements Runnable {
    private ShareData1 shareData;

    public MyRunnable11(ShareData1 shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shareData.increment();
        }
    }
}

class MyRunnable22 implements Runnable {
    private ShareData1 shareData;

    public MyRunnable22(ShareData1 shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shareData.decrement();
        }
    }
}
