package thread.BankingSchedulingOK;

/**
 * Created by admin on 2017/3/15.
 */
public class TicketMachine {
    //内部维护的三个业务队列
    private CustomerQueue generalQueue = new CustomerQueue(BusinessType.GENERAL);
    private CustomerQueue quickQueue = new CustomerQueue(BusinessType.QUICK);
    private CustomerQueue vipQueue = new CustomerQueue(BusinessType.VIP);

    //获取相关业务队列的接口
    public CustomerQueue getCustomerQueue(BusinessType businessType){
        switch(businessType){
            case GENERAL:
                return generalQueue;
            case QUICK:
                return quickQueue;
            case VIP:
                return vipQueue;
        }
        return null;
    }

    //针对不同业务，加入新的客户到对应队列
    public String generateTicket(BusinessType businessType){
        switch(businessType){
            case GENERAL:
                return generalQueue.generateNewCustomer();
            case QUICK:
                return quickQueue.generateNewCustomer();
            case VIP:
                return vipQueue.generateNewCustomer();
        }
        return null;
    }
    //单例实现
    private TicketMachine(){}
    private static TicketMachine machineInstance = new TicketMachine();
    public static TicketMachine getInstance(){
        return machineInstance;
    }
}
