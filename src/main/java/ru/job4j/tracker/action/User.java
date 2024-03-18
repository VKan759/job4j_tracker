package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public interface User {
    String name();

    boolean execute(Input input, Tracker tracker);
}