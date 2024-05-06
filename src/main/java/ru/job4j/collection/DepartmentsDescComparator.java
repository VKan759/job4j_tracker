package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        String[] leftAr = left.split("/");
        String[] rightAr = right.split("/");

        if (leftAr[0].equals(rightAr[0])) {
            return left.compareTo(right);
        }
        return right.compareTo(left);
    }
}