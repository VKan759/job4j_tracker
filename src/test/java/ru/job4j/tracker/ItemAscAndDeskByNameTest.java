package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscAndDeskByNameTest {

    @Test
    void compareItemAscByName() {
        Item second = new Item("Second");
        Item first = new Item("First");
        Item third = new Item("Third");

        List<Item> items = Arrays.asList(
                third, second, first
        );
        List<Item> expected = Arrays.asList(
                first, second, third
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareItemDescByName() {
        Item second = new Item("Second");
        Item first = new Item("First");
        Item third = new Item("Third");

        List<Item> items = Arrays.asList(
                third, second, first
        );
        List<Item> expected = Arrays.asList(
                third, second, first
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}