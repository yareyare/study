package thread.BankingScheduling;

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
