package thread.BankingSchedulingOK;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2017/3/15.
 */

public class MainClass {

    /**
     * 测试代码
     * @param args
     */
    public static void main(String[] args) {
        ScheduledExecutorService timer = null;

        //建立普通窗口
        for(int i = 1 ; i <= 4 ; i ++){
            new Windows(BusinessType.GENERAL,i).start();
        }
        //建立快速窗口
        new Windows(BusinessType.QUICK,1).start();
        //建立VIP窗口
        new Windows(BusinessType.VIP,1).start();
        //普通用户拿票
        timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(
                new Runnable(){
                    public void run(){
                        String name = TicketMachine.getInstance().generateTicket(BusinessType.GENERAL);
                        //System.out.println(name + "正在等待服务...");
                    }
                },
                1,
                Constants.COMMON_ITTERVAL_TIME,
                TimeUnit.SECONDS);
        //快速用户拿票
        timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(
                new Runnable(){
                    public void run(){
                        String name = TicketMachine.getInstance().generateTicket(BusinessType.QUICK);
                        //System.out.println(name + "正在等待服务...");
                    }
                },
                1,
                Constants.COMMON_ITTERVAL_TIME*2,
                TimeUnit.SECONDS);

        //普通用户拿票
        timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(
                new Runnable(){
                    public void run(){
                        String name = TicketMachine.getInstance().generateTicket(BusinessType.VIP);
                        //System.out.println(name + "正在等待服务...");
                    }
                },
                1,
                Constants.COMMON_ITTERVAL_TIME*6,
                TimeUnit.SECONDS);
    }
}
