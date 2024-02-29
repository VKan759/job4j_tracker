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

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int length = 0;
        Item[] result = new Item[100];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[length] = items[i];
                length++;
            }
        }
        return Arrays.copyOf(result, length);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
        }
        return index != -1;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            size--;
        }
    }

}