package thread.mutiThread.productCustom.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/10.
 */
public class ValueObject {

    public static List list = new ArrayList<>();

    public static void add(){
        list.add("anyString");
    }

    public static int size(){
        return list.size();
    }
}
