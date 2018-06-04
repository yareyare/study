package queue;

import org.apache.log4j.Logger;

/**
 * Created by ivy on 2017/12/7.
 */
public class PutElement implements Runnable{

    private static final Logger LOG = Logger.getLogger(PutElement.class);

    @Override
    public void run() {
        int i = 0;
        while (true) {
            int t = ++i;
            LOG.info("放入元素:"+t);
            QueueTest.putElement(t + "");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                LOG.error("----",e);
            }
        }
    }
}
