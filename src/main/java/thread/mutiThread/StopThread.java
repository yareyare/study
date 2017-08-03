package thread.mutiThread;

/**
 * Created by admin on 2017/8/2.
 */
public class StopThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i=0;i<100000;i++){
            System.out.println("i="+i);
            if (this.interrupted()){
                System.out.println("线程中断，循环退出！");
                break;
            }
        }
        System.out.println("线程中断，循环外被打印！线程并未终止");
    }
}

class Runner1{

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        stopThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopThread.interrupt();
    }
}