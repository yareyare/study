package thread.mutiThread;

/**
 * Created by admin on 2017/8/7.
 */
public class PrintString implements Runnable {

    // public boolean isContinuePring = true; //加上volatile也不行
    public static boolean isContinuePring = true;

    public boolean isContinuePring() {
        return isContinuePring;
    }

    public void setContinuePring(boolean continuePring) {
        isContinuePring = continuePring;
    }

    public void pringStringMethod(){
        try {
            while(isContinuePring){
                System.out.println("run pringStringMethod threadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        pringStringMethod();
    }
}

class Run{
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(new PrintString()).start();
        System.out.println("我要停止它！ stop thread="+Thread.currentThread().getName());
        printString.setContinuePring(false);
    }
}
