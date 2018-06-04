package queue;

/**
 * Created by ivy on 2017/12/7.
 */
public class GetElement implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("获取到元素：" + QueueTest.getElement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
