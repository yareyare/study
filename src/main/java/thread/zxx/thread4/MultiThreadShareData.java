package thread.zxx.thread4;

/**
 * Created by ivy on 2017/3/11.
 */
public class MultiThreadShareData {

    public static void main(String[] args) {
        final ShareData shareData1 = new ShareData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int c = 0; c < 100; c++) {
                    shareData1.decrement();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int c = 0; c < 100; c++) {
                    shareData1.increment();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class ShareData {

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
