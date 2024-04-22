package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;


import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndProrityReversed() {
        Comparator<Job> comparator = new JobDescByNameReversed().thenComparing(new JobDescByPriorityReversed());
        int rsl = comparator.compare(
                new Job("First", 2),
                new Job("First", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("First", 2),
                new Job("Second", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("First", 2),
                new Job("Second", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameReversed() {
        Comparator<Job> comparator = new JobDescByNameReversed();
        int rsl = comparator.compare(
                new Job("First", 2),
                new Job("Second", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByPriorityReversed() {
        Comparator<Job> comparator = new JobDescByPriorityReversed();
        int rsl = comparator.compare(
                new Job("First", 2),
                new Job("Second", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}