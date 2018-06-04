package thread.zxx.thread1;

/**
 * Created by ivy on 2017/3/9.
 * 实现线程的两种方式,偏向于第二种方式，把业务类的处理放在Runnable中去实现，Thread负责线程的启动，分工清晰
 */
public class TraditionalThreadFirst {
    public static void main(String[] args) {

/*第一种：实现Thread*/
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
//                    System.out.println(this.getName()); //在这里可以用
                }
            }
        };
        thread.start();

/*第二种：实现Runnable接口*/
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("R-" + Thread.currentThread().getName());
                }
            }
        });
        thread1.start();


//      Thread run方法 与 Runnable的run都实现，则会调用Thread的run方法，而不会调用Runnable的方法
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Runanble-" + Thread.currentThread().getName());
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread-" + Thread.currentThread().getName());
                }
            }
        };
        thread2.start();
    }
}
