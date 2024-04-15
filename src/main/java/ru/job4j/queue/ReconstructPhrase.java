package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements(Deque evenElements) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = evenElements.size();
        for (int index = 0; index < size; index = index + 2) {
                stringBuilder.append(evenElements.pollFirst());
                evenElements.pollFirst();
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements(Deque descendingElements) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = descendingElements.size();
        for (int index = 0; index < size; index++) {
            stringBuilder.append(descendingElements.pollLast());
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements(evenElements) + getDescendingElements(descendingElements);
    }
}