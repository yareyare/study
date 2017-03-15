package thread.zxx.thread2;

/**
 * Created by ivy on 2017/2/23.
 * 描述：先子线程打印10次，然后回到主线程打印5次，如此循环20次
 */
public class TraditionalThreadComunication1 {
    private static boolean main = false;

    public static void main(String argv[]) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 20; i++) {
                    synchronized(TraditionalThreadComunication1.class) {
                        if(main) {
                            try{
                                TraditionalThreadComunication1.class.wait();
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                        for (int j = 0; j < 10; j++) {
                            System.out.println(Thread.currentThread().getName() + " i=" + i + " j=" + j);
                        }

                        main = true;
                        TraditionalThreadComunication1.class.notify();
                    }
                }
            }
        });
        t.start();

        for(int i = 0; i < 20; i++) {
            synchronized(TraditionalThreadComunication1.class) {
                if(!main) {
                    try{
                        TraditionalThreadComunication1.class.wait();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i + " j=" + j);
                }

                main = false;
                TraditionalThreadComunication1.class.notify();
            }
        }
    }
}
