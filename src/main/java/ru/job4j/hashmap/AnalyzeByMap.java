package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int subjectCount = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                score += subject.score();
                subjectCount++;
            }
        }
        return score / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            int subjectCount = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                subjectCount++;
                score += subject.score();
            }
            double averageAmount = score / subjectCount;
            result.add(new Label(pupil.name(), averageAmount));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Set<String> setNames = new HashSet<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                setNames.add(subject.name());
            }
        }

        for (String element : setNames) {
            double score = 0;
            int subjectIteration = 0;
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    if (element.equals(subject.name())) {
                        score += subject.score();
                        subjectIteration++;
                    }
                }
            }
            map.put(element, (int) score / subjectIteration);
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            result.add(new Label(m.getKey(), m.getValue()));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label result = null;
        int sumScore = 0;
        for (Pupil pupil : pupils) {
            int score = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                score += subject.score();
            }
            if (score > sumScore) {
                sumScore = score;
                result = new Label(pupil.name(), sumScore);
            }
        }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Set<String> setNames = new HashSet<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        Label result = null;
        int bestScore = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                setNames.add(subject.name());
            }
        }

        for (String element : setNames) {
            double score = 0;
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    if (element.equals(subject.name())) {
                        score += subject.score();
                    }
                }
            }
            map.put(element, (int) score);
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > bestScore) {
                bestScore = m.getValue();
                result = new Label(m.getKey(), bestScore);
            }
        }
        return result;
    }
}
