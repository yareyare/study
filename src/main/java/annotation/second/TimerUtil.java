package annotation.second;

public class TimerUtil {

    public void getTime(Callback callback) {
        long start = System.currentTimeMillis();
        callback.execute();
        long end = System.currentTimeMillis();
        System.out.println("执行时间:"+ (end - start));
    }

}
