package jvm.b;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2018/6/3.
 * jconsole命令查看进程
 * b数组作为成员变量，对内存会一直上涨，eden区会M状曲线，survivor区会呈折线。old区折线式上涨
 *
 */
public class JconsoleTest_gaijin {

    public JconsoleTest_gaijin(){
        byte[] b = new byte[128*1024];
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fill(1000);

    }

    private static void fill(int n){


        List<JconsoleTest_gaijin> list = new ArrayList<>();
        for (int i =0;i<n;i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            JconsoleTest_gaijin test = new JconsoleTest_gaijin();
            list.add(test);
            System.out.println(i);
        }
    }

}