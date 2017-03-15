package thread.t1t2t3;

/**
 * Created by ivy on 2017/3/8.
 */
public class T2 implements Runnable {

    public void run() {
        int i = 0 ;
        while(true) {

            System.out.println("T2");
            i++;
            if(i==10){
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

