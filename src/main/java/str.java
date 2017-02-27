/**
 * Created by ivy on 2017/2/16.
 */
public class str {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hell" + new String("o");
        System.out.println(a == b);
        String aa = "hello";
        String bb = new String("hello");
        String cc = new String("hello");
        System.out.println(aa==bb);
        System.out.println(cc==bb);

        System.out.println(bb.equals(cc));
        System.out.println(a.equals(b));
    }
}
