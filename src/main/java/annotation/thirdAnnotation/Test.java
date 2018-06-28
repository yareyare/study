package annotation.thirdAnnotation;


public class Test {

    @Timer
    private static int add() {
        try {
            Thread.sleep(1000);
            return 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int sub() {
        try {
            Thread.sleep(1000);
            return 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        // 方法有参数的话就不行了, 而且，扫描类的时候直接点位数组下标这也是不可通用的
        TimerUtil tu = new TimerUtil();
        tu.getTime();

    }
}
