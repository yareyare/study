package queue;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by ivy on 2017/12/7.
 */
public class QueueTest {

    private static final Logger LOG = Logger.getLogger(QueueTest.class);

    public static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

    public static String getElement(){
        String element = null;
        try {
            element = queue.take();// 取队列第一个元素
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public static String putElement(String str){
        try {
            queue.put(str);
        } catch (InterruptedException e) {
            LOG.error("天津元素失败",e);
        }
        return null;
    }
}
//    boolean add(E e) ，把 e 添加到BlockingQueue里。如果BlockingQueue可以容纳，则返回true，否则抛出异常。
//    boolean offer(E e)，表示如果可能的话,将 e 加到BlockingQueue里，即如果BlockingQueue可以容纳，则返回true，否则返回false。
//    void put(E e)，把 e 添加到BlockingQueue里，如果BlockQueue没有空间，则调用此方法的线程被阻塞直到BlockingQueue里面有空间再继续。
//    E poll(long timeout, TimeUnit unit) ，取走BlockingQueue里排在首位的对象，若不能立即取出，则可以等time参数规定的时间，取不到时返回null。
//    E take() ，取走BlockingQueue里排在首位的对象,若BlockingQueue为空，则调用此方法的线程被阻塞直到BlockingQueue有新的数据被加入。
//    int drainTo(Collection<? super E> c) 和 int drainTo(Collection<? super E> c, int maxElements) ，一次性从BlockingQueue获取所有可用的数据对象（还可以指定获取　数据的个数），通过该方法，可以提升获取数据效率，不需要多次分批加锁或释放锁。