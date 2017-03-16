package thread.BankingSchedulingOK;

/**
 * Created by admin on 2017/3/15.
 * 业务类型
 */
public enum BusinessType {
    GENERAL,  //普通业务类型
    QUICK,  //快速业务类型
    VIP;  //VIP业务类型

    @Override
    public String toString() {
        switch(this){
            case GENERAL:
                return "普通";
            case QUICK:
                return "快速";
            case VIP:
                return "VIP";
        }
        return null;
    }
}
