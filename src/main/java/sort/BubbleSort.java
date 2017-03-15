package sort;

import java.util.List;

/**
 * Created by ivy on 2017/2/27.
 * 描述：冒泡排序
 * 思想：大数下沉，小数上浮
 */
public class BubbleSort {

    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for(int j = i+1; j<a.length; j++){
                if(a[j]<a[i]){
                    int swap = a[j];
                    a[j]=a[i];
                    a[i]=swap;
                }
            }
        }
    }

    public static void bubbleSort(int[] a){
        int temp;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
