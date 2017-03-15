package thread.zxx.thread3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ivy on 2017/3/11.
 * 线程范围内共享变量的概念和作用
 * A模块和B模块不一定能拿到的都是当前线程的数据
 */
public class ThreadScopeShareDataErr {
    private static int data = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " creat a data " + data);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public static int getData() {
            System.out.println("A get data from " + Thread.currentThread().getName() + " is " + data);
            return data;
        }
    }

    static class B {
        public static int getData() {
            System.out.println("B get data from " + Thread.currentThread().getName() + " is " + data);
            return data;
        }
    }
}
