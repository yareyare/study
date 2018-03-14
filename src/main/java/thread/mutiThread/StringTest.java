package thread.mutiThread;

/**
 * Created by admin on 2017/8/7.
 */
public class StringTest {
    public static void main(String[] args) {

        //test1();

        test2();
    }

    /** 没有“对象监视器”，也就是没有同步加锁 **/
    public static void test1(){
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** 有对象监视器，可以进入等待状态                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            **/
    public static void test2(){
        try {
            String lock = new String();
            System.out.println("syn in");
            synchronized (lock){
                System.out.println("syn 1");
                lock.wait();
                System.out.println("syn wait()");
            }
            System.out.println("syn out");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
