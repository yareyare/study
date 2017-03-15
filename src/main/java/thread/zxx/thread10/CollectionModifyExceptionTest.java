package thread.zxx.thread10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ivy on 2017/3/12.
 */
public class CollectionModifyExceptionTest {

    public static void main(String[] args) {

//        Collection c  = new ArrayList<User>();

        Collection c = new CopyOnWriteArrayList<>();

        c.add(new User("张三",20));
        c.add(new User("李四",10));
        c.add(new User("王五",30));

        Iterator<User> iterator = c.iterator();
        while(iterator.hasNext()){
            System.out.println("hasNext");
            User u = iterator.next();
            if(u.getName().equals("张三")){
                c.remove(u);
            }else{
                System.out.println(u.getName());
            }
        }
    }
}
