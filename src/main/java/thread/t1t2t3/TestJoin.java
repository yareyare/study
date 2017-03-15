package thread.t1t2t3;

/**
 * Created by ivy on 2017/3/8.
 */

/**
 * join 方法使得异步执行的线程变成同步执行
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        Thread t3 = new Thread(new T3());

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }catch (Exception e){

        }
    }
}
