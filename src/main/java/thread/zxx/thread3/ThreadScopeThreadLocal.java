package thread.zxx.thread3;

import java.util.Random;

/**
 * Created by ivy on 2017/3/11.
 */
public class ThreadScopeThreadLocal {
    private static Integer data = 0;
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static ThreadLocal<Person> threadLocalPerson = new ThreadLocal<Person>();
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " creat a data " + data);
                    threadLocal.set(data); //往当前线程放数据
                    threadLocalPerson.set(new Person("name"+data,data));
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public static void getData() {
            System.out.println("A get data from " + Thread.currentThread().getName() + " is " + threadLocal.get());
            System.out.println("A get Person from " + Thread.currentThread().getName() + " is " + threadLocalPerson.get().toString());
        }
    }

    static class B {
        public static void getData() {
            System.out.println("B get data from " + Thread.currentThread().getName() + " is " + threadLocal.get());
            System.out.println("B get Person from " + Thread.currentThread().getName() + " is " + threadLocalPerson.get().toString());
        }
    }
}

class Person{
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName()+" "+this.getAge();
    }
}