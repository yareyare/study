package thread.BankingScheduling;

/**
 * Created by ivy on 2017/3/14.
 */
public class Window {
    private String type;
    private Integer windowNum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWindowNum() {
        return windowNum;
    }

    public void setWindowNum(Integer windowNum) {
        this.windowNum = windowNum;
    }

    public Window(String type, Integer windowNum) {
        this.type = type;
        this.windowNum = windowNum;
    }

    public Window() {
    }

    public  static void vip(Customer c){
        if (c==null){
            System.out.println("vip窗口 空闲一次");
            return;
        }
        System.out.println(c.getType()+"用户处理业务            "+c.getSeq());
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getType()+"用户处理业务处理完成          "+c.getSeq());
    }

    public  static void quick(Customer c){
        if (c==null){
            System.out.println("quick窗口 空闲一次");
            return;
        }
        System.out.println(c.getType()+"用户处理业务             "+c.getSeq());
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getType()+"用户处理业务处理完成         "+c.getSeq());
    }

    public  static void domenstic(Customer c){
        if (c==null){
            System.out.println("domenstic窗口 空闲一次");
            return;
        }
        System.out.println(c.getType()+"用户处理业务             "+c.getSeq());
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getType()+"用户处理业务处理完成          "+c.getSeq());
    }
}
