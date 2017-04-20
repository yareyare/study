package design.observer;

/**
 * Created by ivy on 2017/3/17.
 */
public class Police implements Watcher {
    @Override
    public void active()
    {
        System.out.println("运输车有行动，警察护航");
    }
}
