package thread.zxx.thread2;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ivy on 2017/3/11.
 */
public class TraditionalTimerTest {
    //TimeTasker
    private static void timeTasker1() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        }, 1000, 3000);
    }

    public static void main(String[] args) {
//        10秒后每隔1秒执行一次
        timeTasker1();
    }
}
