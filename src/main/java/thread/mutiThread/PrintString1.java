package thread.mutiThread;

/**
 * Created by admin on 2017/8/7.
 */
public class PrintString1 extends Thread{

    volatile  private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("run() 进入");
        while (isRunning){
            System.out.println("running ...");
        }
        System.out.println("run() 执行完毕");
    }
}

class Run1{
    public static void main(String[] args) {
        try {
            PrintString1 thread = new PrintString1();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("停止命令");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}