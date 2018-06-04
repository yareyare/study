package thread.mutiThread.WaitGtNotify;

/**
 * Created by admin on 2017/8/10.
 */
public class ThreadSubtract extends Thread {

    private Subtract subtract;

    public ThreadSubtract(Subtract subtract){
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }
}
