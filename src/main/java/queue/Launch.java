package queue;

import org.apache.log4j.Logger;

/**
 * Created by zhangyan on 16/8/12.
 */
public class Launch {

    private static final Logger LOG = Logger.getLogger(Launch.class);

    private final static int httpPort = 9000;

    public static void main(String[] args) {
        Thread putThread = new Thread(new PutElement());
        Thread GetThread = new Thread(new GetElement());
        GetThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        putThread.start();
    }
}
