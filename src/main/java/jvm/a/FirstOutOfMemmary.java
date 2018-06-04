package jvm.a;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/**
 * Created by ivy on 2018/6/3.
 */
public class FirstOutOfMemmary {

    public static void main(String[] args) {
        ArrayList<Demo> list = new ArrayList<>();
        while (true){
            Demo demo = new Demo();
            list.add(demo);
        }
    }

    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
}
