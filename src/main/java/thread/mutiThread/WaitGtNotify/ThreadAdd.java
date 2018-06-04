package thread.mutiThread.WaitGtNotify;

/**
 * Created by admin on 2017/8/10.
 */
public class ThreadAdd extends Thread {

    private Add add ;

    public ThreadAdd(Add add){
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
