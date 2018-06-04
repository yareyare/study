package thread.zxx.thread2;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ivy on 2017/3/11.
 *
 * 实现定时器2秒执行1次，4秒执行一次
 */
public class TraditionalTimerTest {
    private static int count = 0;
    //TimeTasker
    private static void timeTasker1() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        }, 1000, 3000);
    }


    //TimeTasker 子母弹
    private static void timeTasker2() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing~");
                    }
                },3000);
            }
        }, 2000);
    }

    //TimeTasker
    private static void timeTasker3() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");

                //java.lang.IllegalStateException: Task already scheduled or cancelled
                new Timer().schedule(/*new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing~");
                    }
                }*/ this,3000);
            }
        }, 2000);
    }


    class MyTasker extends TimerTask{

        @Override
        public void run() {
            count = (count + 1)%2;

            System.out.println("bombing");
            new Timer().schedule( new MyTasker(),2000+2000*count);
        }
    }

    //TimeTasker
    private void timeTasker4() {
        new Timer().schedule(new MyTasker(),2000);
    }

    public static void main(String[] args) throws InterruptedException {
//        10秒后每隔1秒执行一次
        //timeTasker1();
//        timeTasker2();
//        timeTasker3();
        new TraditionalTimerTest().timeTasker4();

        int i =0;
        while (true){
            Thread.sleep(1000);
            System.out.println(i++);
        }
    }
}


