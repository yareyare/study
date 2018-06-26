
/**
 * Created by ivy on 2017/2/16.
 */
public class str {
    public static void main(String[] args) {
//        String a = "hello";
//        String b = "hell" + new String("o");
//        System.out.println(a == b);
//        String aa = "hello";
//        String bb = new String("hello");
//        String cc = new String("hello");
//        System.out.println(aa==bb);
//        System.out.println(cc==bb);
//
//        System.out.println(bb.equals(cc));
//        System.out.println(a.equals(b));

        int[] arr_a = new int[]{1,2,3,6,7};
        int[] arr_b = new int[]{1,2,4,6,8,9};
        int[] combin = combin(arr_a, arr_b);
        for (int i=0;i<combin.length;i++){
            System.out.println(combin[i]);
        }
    }


    private static int[] combin(int[] a, int[] b){
        int[] c = new int[a.length+b.length];

        int m = 0,n = 0 ;
        for (int i = 0;i<=c.length;i++){
            if (a[m] <= b[n]){
                c[i] = a[m];
                m ++;
                if (m == a.length){
                    for (int j = n ; j<b.length ; j++){
                        i++;
                        c[i] = b[j];
                    }
                    return c;
                }
            }else if (a[m] > b[n]){
                c[i] = b[n];
                n ++;
                if (n == b.length){
                    for (int j = m ; j<a.length ; j++){
                        i++;
                        c[i] = a[j];
                    }
                    return c;
                }
            }

        }
        return c;
    }

    private static void combin1(int[] a, int[] b){


    }


}
