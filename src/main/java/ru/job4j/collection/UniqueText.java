package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String oText : origin) {
            check.add(oText);
        }
        for (String dText : text) {
            if (!check.contains(dText)) {
                result = false;
                break;
            }
        }
        return result;
    }
}