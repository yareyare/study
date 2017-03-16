package thread.BankingSchedulingOK;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 2017/3/15.
 */
public class CustomerQueue {

    private BusinessType businessType;//队列的业务类型
    private int customerNum = 1;//记录用户队列号
    List<String> queue = new LinkedList<String>();//队列载体

    public CustomerQueue(BusinessType businessType) {
        super();
        this.businessType = businessType;
    }

    //产生新的号码，加入到队列
    public synchronized String generateNewCustomer(){
        String name = businessType+"客户_"+(customerNum++)+"号";
        if(queue.add(name))
            return name;
        else
            return null;
    }

    //从队列中取出第一个客户
    public synchronized String getCustomer(){
        if(!isEmpty())
            return queue.remove(0);
        else
            return null;
    }

    //判断队列是否为空，即是否有客户等待业务
    public synchronized boolean isEmpty(){
        if(queue.size() > 0)
            return false;
        else
            return true;
    }
}
