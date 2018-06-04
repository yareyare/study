package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ivy on 2017/3/18.
 */
public class RemoveFromList {

    TreeMap tree = new TreeMap();
    private static void remove(){
        List list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()){
            Integer i = it.next();
            if (i==1){
                it.remove();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        remove();
    }
}
