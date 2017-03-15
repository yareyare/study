package thread.zxx.thread3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ivy on 2017/3/11.
 * 线程范围内共享变量的概念和作用。让共享资源在线程内共享，在线程外独立
 *
 * 用户A用connection对象conn1 beginTransation()对一个账户做多次操作，然后conn1.commit
 * 同时用户B也用connection对象conn1 beginTransation()对一个账户做多次操作，然后conn1.commit
 * 这种情况下就要求conn对在用户A的处理流程内共享，相对用户B的流程要独立才安全
 * A模块和B模块拿到的都是当前线程的数据
 */
public class ThreadScopeShareDataOK {
    private static int data = 0;

    private static Map<Thread, Integer> ThreadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " creat a data " + data);
                    ThreadData.put(Thread.currentThread(),data);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public static void getData() {
            System.out.println("A get data from " + Thread.currentThread().getName() + " is " + ThreadData.get(Thread.currentThread()));
        }
    }

    static class B {
        public static void getData() {
            System.out.println("B get data from " + Thread.currentThread().getName() + " is " + ThreadData.get(Thread.currentThread()));
        }
    }
}
