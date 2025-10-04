package org.example.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        Iterator<String> iter = names.iterator(); // без итератора был бы ConcurrentModificationException, так как for-each нарушается согласованность modCount

        while (iter.hasNext()) {
            var el = iter.next();
            if (el.startsWith("A")) {
                iter.remove();
            }

        }
        System.out.println(names);
    }
}
