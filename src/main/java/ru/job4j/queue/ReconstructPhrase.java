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
        for (int index = 0; index < evenElements.size(); index++) {
            stringBuilder.append(evenElements.pollFirst());
            evenElements.pollFirst();
            index = 0;
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements(Deque descendingElements) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index <= descendingElements.size(); index++) {
            stringBuilder.append(descendingElements.pollLast());
            index = 0;
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements(evenElements) + getDescendingElements(descendingElements);
    }
}