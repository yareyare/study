package thread.mutiThread.susbendResum;

/**
 * Created by admin on 2017/8/3.
 * suspend 与 resume 方法的缺点 -- 不同步
 */
public class MyObject {
    private String username = "1";
    private String password = "11";
    public void setValue(String u,String p){
        this.username =  u;
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("停止 a 线程 ！");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }

    public void pringUser(){
        System.out.println(username+" "+password);
    }
}

class Runner3{
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();
        Thread thread = new Thread(){
            @Override
            public void run() {
                myObject.setValue("a","aa");
            }
        };
        thread.setName("a");
        thread.start();
        thread.sleep(500);

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                myObject.pringUser();
            }
        };
        thread2.start();

    }
}
