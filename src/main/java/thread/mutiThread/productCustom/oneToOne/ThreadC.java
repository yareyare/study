package thread.mutiThread.productCustom.oneToOne;

/**
 * Created by admin on 2017/8/10.
 */
public class ThreadC extends Thread {

    private C c;

    public ThreadC(C c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
