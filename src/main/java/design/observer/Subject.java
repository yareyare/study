package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2017/3/17.
 *
 *抽象主题(Subject)角色
 *
 */
interface Subject {
    public List<Watcher> list = new ArrayList<Watcher>();

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers();
}
