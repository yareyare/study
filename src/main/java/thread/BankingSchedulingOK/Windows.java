package thread.BankingSchedulingOK;

import thread.BankingScheduling.Customer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2017/3/15.
 */
public class Windows {
    private BusinessType businessType;//窗口业务类型
    private int winNum;//窗口编号
    private boolean available = false;//窗口开放状态

    public Windows(BusinessType businessType,int winNum) {
        super();
        this.businessType = businessType;
        this.winNum = winNum;
    }

    //开始业务
    public void start(){
        available = true;
        System.out.println(this+"开始服务！");

        //创建新的线程开始不同窗口的业务
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(new Runnable(){
            public void run(){
                switch(businessType){
                    case GENERAL:
                        while(available){
                            generalService();
                        }
                    case QUICK:
                        while(available){
                            quickService();
                        }
                    case VIP:
                        while(available){
                            vipService();
                        }
                }
            }
        });
    }
    //普通业务窗口服务过程
    private void generalService(){
        //普通业务只需要获得普通用户队列
        CustomerQueue queue = TicketMachine.getInstance().getCustomerQueue(BusinessType.GENERAL);
        //如果队列不为空，则开始叫号并模拟服务
        if(!queue.isEmpty()){
            String name = queue.getCustomer();
            System.out.println(this+"正在为 "+name+"服务~");
            int time = generalCustomerServicing();
            //System.out.println(this+"服务完毕，耗时"+time+"秒");
        }
        else{
            //System.out.println(this+"正在等待客户...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //快速窗口业务服务过程
    private void quickService(){
        //快速窗口需要得到快速队列以及普通队列
        CustomerQueue quickQueue = TicketMachine.getInstance().getCustomerQueue(BusinessType.QUICK);
        CustomerQueue generalQueue = TicketMachine.getInstance().getCustomerQueue(BusinessType.GENERAL);

        //首先判断快速队列
        if(!quickQueue.isEmpty()){
            String name = quickQueue.getCustomer();
            System.out.println(this+"正在为 "+name+"服务~");
            int time = quickCustomerServicing();
            //System.out.println(this+"服务完毕，耗时"+time+"秒");
        }
        //若快速队列没有等待客户，则考虑普通队列
        else if(!generalQueue.isEmpty()){
            String name = generalQueue.getCustomer();
            System.out.println(this+"正在为 "+name+"服务~");
            int time = generalCustomerServicing();
            //System.out.println(this+"服务完毕，耗时"+time+"秒");
        }
        else{
            //System.out.println(this+"正在等待客户...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //vip窗口业务服务过程
    private void vipService(){
        //vip窗口需要得到的vip队列以及普通队列
        CustomerQueue vipQueue = TicketMachine.getInstance().getCustomerQueue(BusinessType.VIP);
        CustomerQueue generalQueue = TicketMachine.getInstance().getCustomerQueue(BusinessType.GENERAL);

        //如果vip队列不为空，则取出vip客户处理
        if(!vipQueue.isEmpty()){
            String name = vipQueue.getCustomer();
            System.out.println(this+"正在为 "+name+"服务~");
            int time = vipCustomerServicing();
            //System.out.println(this+"服务完毕，耗时"+time+"秒");
        }
        //若vip队列为空，则考虑普通队列
        else if(!generalQueue.isEmpty()){
            String name = generalQueue.getCustomer();
            System.out.println(this+"正在为 "+name+"服务~");
            int time = generalCustomerServicing();
            //System.out.println(this+"服务完毕，耗时"+time+"秒");
        }
        else{
            //System.out.println(this+"正在等待客户...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    //服务普通客户的模拟时间
    private int generalCustomerServicing(){
        int time = new Random().nextInt(
                Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME)+
                Constants.MIN_SERVICE_TIME;
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;
    }
    //服务快速客户的模拟时间
    private int quickCustomerServicing(){
        int time = Constants.MIN_SERVICE_TIME;
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;
    }
    //服务vip客户的模拟时间
    private int vipCustomerServicing(){
        int time = new Random().nextInt(
                Constants.MAX_SERVICE_TIME-Constants.MIN_SERVICE_TIME)+
                Constants.MIN_SERVICE_TIME;
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return businessType+"窗口"+winNum+"号";
    }
}
