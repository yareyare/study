package thread.mutiThread;

/**
 * Created by admin on 2017/8/2.
 */
public class InterruptTest extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i=0;i<50;i++){
            System.out.println("i="+i);
        }
    }
}

class Runner{

    private static void test1(){
        try {
            InterruptTest myThread = new InterruptTest();
            myThread.start();

//            System.out.println(Thread.currentThread().getName());
//            myThread.interrupt();//main被终端

            System.out.println(myThread.getName());
            Thread.currentThread().interrupt();//myThread 被终端

            System.out.println("是否停止1："+myThread.interrupted());
            System.out.println("是否停止2："+myThread.interrupted()); //第一次调用就被终端了，第二次调用该接口会返回false，（见源码）

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2(){
        try {
            InterruptTest myThread = new InterruptTest();
            myThread.start();

            System.out.println(myThread.getName());
            System.out.println("是否停止 前："+myThread.isInterrupted());
            myThread.interrupt();
//            System.out.println("是否停止 后1："+myThread.isInterrupted());
//            System.out.println("是否停止 后2："+myThread.isInterrupted()); //第一次调用就被终端了，第二次调用该接口会返回false，（见源码）

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test1();
        test2();
    }
}
