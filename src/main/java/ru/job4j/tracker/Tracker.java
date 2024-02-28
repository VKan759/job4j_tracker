package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int length = 0;
        Item[] result = new Item[100];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null
                    && items[i].getName().equals(key)) {
                result[length] = items[i];
                length++;
            }
        }
        return Arrays.copyOf(result, length);
    }
}