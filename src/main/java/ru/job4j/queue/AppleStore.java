package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int index = 0; index < count; index++) {
            if (count - 1 == index) {
                break;
            }
            queue.poll();
        }
        return queue.peek().name();
    }

    public String getFirstUpsetCustomer() {
        for (int index = 0; index <= count; index++) {
            if (count == index) {
                break;
            }
            queue.poll();
        }
        return queue.peek().name();
    }

}