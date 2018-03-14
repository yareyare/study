package thread.mutiThread.stop;

/**
 * Created by admin on 2017/8/3.
 *
 * 用抛异常的方式终止线程
 */
public class ThreadExceptionToStop extends Thread {

    private long i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class stopThread{
    public static void main(String[] args) {
        ThreadExceptionToStop threadExceptionToStop = new ThreadExceptionToStop();
        threadExceptionToStop.start();
        System.out.println("main end");
    }
}