package annotation.first;

public class Main1 {

    // 冗余代码太多

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        add(1,2);
        long spend = System.currentTimeMillis() - start;
        System.out.println("execute() spend : " + spend);

        long start2 = System.currentTimeMillis();
        sub(2,1);
        long spend2 = System.currentTimeMillis() - start;
        System.out.println("execute2() spend : " + spend);
    }

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
}
