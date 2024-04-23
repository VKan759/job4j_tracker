package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int iterationCount = Math.min(left.length(), right.length());
        for (int i = 0; i < iterationCount - 1; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                break;
            } else {
                result = Integer.compare(left.length(), right.length());
            }
        }
        return result;
    }
}