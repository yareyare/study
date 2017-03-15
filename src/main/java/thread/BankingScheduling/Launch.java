package thread.BankingScheduling;

import sun.plugin2.message.CustomSecurityManagerRequestMessage;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ivy on 2017/3/14.
 */
public class Launch {

    public static void main(String[] args) {

        WindowCall.callDomestic();
        WindowCall.callQuick();
        WindowCall.callVip();

        CustomerQueue.customerQueue();
    }

}
