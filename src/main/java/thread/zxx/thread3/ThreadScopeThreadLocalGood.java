package thread.zxx.thread3;

import java.util.Random;

/**
 * Created by ivy on 2017/3/11.
 */
public class ThreadScopeThreadLocalGood {
    private Integer data = 0;
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
//    private static ThreadLocal<MyThreadScopeData> threadLocalPerson = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadScopeThreadLocalGood test = new ThreadScopeThreadLocalGood();
                    test.data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " creat a data " + test.data);
//                    threadLocal.set(data); //往当前线程放数据
//                    threadLocalPerson.set(new MyThreadScopeData("name" + data, data));

                    MyThreadScopeData mydata = MyThreadScopeData.getInstance();
                    mydata.setName("name" + test.data);
                    mydata.setAge(test.data);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public static void getData() {
//            System.out.println("A get data from " + Thread.currentThread().getName() + " is " + threadLocal.get());
//            System.out.println("A get Person from " + Thread.currentThread().getName() + " is " + threadLocalPerson.get().toString());
            MyThreadScopeData myData = MyThreadScopeData.getInstance() ;
            System.out.println("A get Person from " + Thread.currentThread().getName() + " is " + myData.getName());
        }
    }

    static class B {
        public static void getData() {
//            System.out.println("B get data from " + Thread.currentThread().getName() + " is " + threadLocal.get());
//            System.out.println("B get Person from " + Thread.currentThread().getName() + " is " + threadLocalPerson.get().toString());
            MyThreadScopeData myData = MyThreadScopeData.getInstance() ;
            System.out.println("B get Person from " + Thread.currentThread().getName() + " is " + myData.getName());
        }
    }
}

//单例模式是在同一个线程内只会有一个对象，n个实例有n个单例对象。 这里我们要的是n个线程中，每个线程有一个属于自己的对象
class MyThreadScopeData {

    private MyThreadScopeData() {
    }

//    private static MyThreadScopeData instance = null;


    public static /*synchronized*/ MyThreadScopeData getInstance() {
        MyThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private String name;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyThreadScopeData(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return this.getName() + " " + this.getAge();
//    }
}