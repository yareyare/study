package annotation.second;



public class Test {

    private static int add(int a, int b) {
        try {
            Thread.sleep(1000);
            return a + b;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int sub(int a, int b) {
        try {
            Thread.sleep(1000);
            return a - b;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        TimerUtil timeUtil = new TimerUtil();
        timeUtil.getTime(new Callback() {
            @Override
            public void execute() {
                add(1,1);
            }
        });
        timeUtil.getTime(new Callback() {
            @Override
            public void execute() {
                sub(2,1);
            }
        });
    }
}
