package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() > element.getPriority()) {
                index++;
                continue;
            }
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            if (task.getPriority() == element.getPriority()) {
                index++;
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}