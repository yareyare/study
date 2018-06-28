package annotation.thirdAnnotation;

import java.util.*;

public class TimerUtil1 {

    // 修改getTime()
    public HashMap<String, Long> getMethodsTable() {
        HashMap<String, Long> methodsTable = new HashMap<>();
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        // ...
        return methodsTable;
    }

    public void printChart() {
        Map<String, Long> result = sortByValue(getMethodsTable());
        double max = result.values().iterator().next();
        for (Map.Entry<String, Long> e : result.entrySet()) {
            double index = e.getValue() / max * 100;
            for (int i = 0; i < index; i++) {
                System.out.print("=");
            }
            System.out.println(e.getKey() + "()" + " Index:" + (long) index + " Time:" + e.getValue());
        }
    }

    <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        // desc order
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
