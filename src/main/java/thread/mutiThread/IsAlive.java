package thread.mutiThread;

/**
 * Created by admin on 2017/8/2.
 */
public class IsAlive extends Thread{

    @Override
    public void run() {
        System.out.println("run====begin=====");
        System.out.println("run Thread.currentThread().getName()"+Thread.currentThread().getName());
        System.out.println("run Thread.currentThread().isAlive()"+Thread.currentThread().isAlive());
        System.out.println("run "+this.getName()+" alive:"+this.isAlive());
        System.out.println("run====end====");
    }

    public IsAlive(){
        System.out.println("构造====begin=====");
        System.out.println("构造Thread.currentThread().getName()"+Thread.currentThread().getName());
        System.out.println("构造Thread.currentThread().isAlive()"+Thread.currentThread().isAlive());
        System.out.println("构造:"+this.getName()+" alive:"+this.isAlive());
        System.out.println("构造====end====");
    }

    public static void main(String[] args) {
//        IsAlive alive = new IsAlive();
//        alive.start();

        IsAlive alive = new IsAlive();
        Thread t = new Thread(alive);
        System.out.println("main t begin "+t.isAlive());
        t.setName("T");
        t.start();
        System.out.println("main t end "+t.isAlive());

    }

}
