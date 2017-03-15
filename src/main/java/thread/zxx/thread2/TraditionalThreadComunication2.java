package thread.zxx.thread2;

/**
 * Created by ivy on 2017/3/11.
 */
public class TraditionalThreadComunication2 {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    business.sub(10);

                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
                business.main(5);

        }
    }


}

class Business {
    //自己管理自己的状态，不要让外面的线程去管
    private boolean subRun = true;
    public synchronized void main(int n) {
        while(subRun){  //这里用while比用if好，可以防止为唤醒。看wait的Api
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("主==" + i);
        }
        subRun=true;
        this.notify();
    }

    public synchronized void sub(int n) {
        while(!subRun){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("子" + i);
        }
        subRun=false;
        this.notify();
    }
}