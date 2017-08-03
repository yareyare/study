package design.observer;

/**
 * Created by ivy on 2017/3/17.
 * 强盗
 */
public class Thief implements Watcher {

    @Override
    public void active() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}
