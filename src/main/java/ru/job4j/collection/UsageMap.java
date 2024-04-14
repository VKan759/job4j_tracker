package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("vkan759@gmail.com", "Vyacheslav Kan");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("asp@gmail.com", "Alexey Sobolev");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
