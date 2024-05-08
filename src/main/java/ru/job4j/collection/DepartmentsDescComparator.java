package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftAr = left.split("/");
        String[] rightAr = right.split("/");
        int result = rightAr[0].compareTo(leftAr[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}