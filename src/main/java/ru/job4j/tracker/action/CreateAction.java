package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.MemTracker;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Добавить новую заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return true;
    }
}
