package thread.zxx.thread4;

/**
 * Created by ivy on 2017/3/11.
 * 将共享数据封装到另外一个对象中，然后将这个对象逐一给各个Runnable对象，
 * 每个线程对共享数据的操作方法也分配到那个对象身上去完成，这样容易实现针对该数据进行各种操作的互斥和通信
 */
public class MultiThreadShareDataSimple1 {

    public static void main(String[] args) {
        ShareData1 shareData = new ShareData1();
        new Thread(new MyRunnable1(shareData)).start();
        new Thread(new MyRunnable2(shareData)).start();
    }
}


class MyRunnable1 implements Runnable {
    private ShareData1 shareData;

    public MyRunnable1(ShareData1 shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shareData.increment();
        }
    }
}

class MyRunnable2 implements Runnable {
    private ShareData1 shareData;

    public MyRunnable2(ShareData1 shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            shareData.decrement();
        }
    }
}


class ShareData1 {

    private static int i = 100;

    public static synchronized void increment() {
        i++;
        System.out.println("in " + i);
    }

    public static synchronized void decrement() {
        i--;
        System.out.println("de " + i);
    }


}
