package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2017/3/17.
 * 具体的被观察者 运输员
 *
 * 具体主题(ConcreteSubject)角色
 */
public class Transporter implements Subject {

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        for (Watcher watcher : list) {
            watcher.active();
        }
    }
}
