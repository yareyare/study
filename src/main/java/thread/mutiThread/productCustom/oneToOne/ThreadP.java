package thread.mutiThread.productCustom.oneToOne;

/**
 * Created by admin on 2017/8/10.
 */
public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p){
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
