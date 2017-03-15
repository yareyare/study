package sort;

/**
 * Created by ivy on 2017/2/27.
 * 测试
 */
public class Test {



    private static void print(int[] a){
        for (int i =0 ;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        int[] a = {2,5,1,6,33,-1,1000};
        BubbleSort.sort(a);
//        print(a);

        int a1[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        BubbleSort.bubbleSort(a1);
        print(a1);
    }
}
