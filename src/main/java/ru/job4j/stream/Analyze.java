package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMapToDouble(pupil -> pupil.subjects().stream().mapToDouble(Subject::score))
                .average().orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {

        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects()
                        .stream()
                        .mapToDouble(Subject::score).average().orElse(0)))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> temp = stream
                .flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)));
        return temp.entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(stringDoubleEntry.getKey(), stringDoubleEntry.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects()
                                .stream()
                                .mapToDouble(Subject::score)
                                .sum()))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> temp = stream
                .flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)));

        return temp.entrySet()
                .stream()
                .map(stringDoubleEntry -> new Tuple(stringDoubleEntry.getKey(), stringDoubleEntry.getValue()))
                .max(Comparator.comparing(Tuple::score)).orElse(null);
    }
}