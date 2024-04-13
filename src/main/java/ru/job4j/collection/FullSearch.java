package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> task) {
        HashSet<String> array = new HashSet<>();
        for (Task t : task) {
            array.add(t.getNumber());
        }
        return array;
    }
}
