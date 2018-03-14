package thread.mutiThread.WaitGtNotify;

/**
 * Created by admin on 2017/8/10.
 */
public class Run {

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            Add add = new Add(lock);
            ThreadAdd threadAdd = new ThreadAdd(add);
            ThreadAdd threadAdd1 = new ThreadAdd(add);
            Subtract subtract = new Subtract(lock);
            ThreadSubtract threadSubtract1 = new ThreadSubtract(subtract);
            ThreadSubtract threadSubtract2 = new ThreadSubtract(subtract);


            threadSubtract1.start();
            threadSubtract2.start();
            Thread.sleep(1000);
            threadAdd.start();
            threadAdd1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 当两个线程读list大小为0时进入等待状态
 * 当add线程执行添加操作时同事唤醒了两个读list的线程，其中一个读线程执行后删除了list元素，而另外一个线程执行删除时就下表越界了
 *
 * 解决方法Subtract.subtract()方法中用while
 *  */