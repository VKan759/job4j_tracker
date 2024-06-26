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
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            result.add(new Label(m.getKey(), (double) m.getValue() / pupils.size()));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                score += subject.score();
            }
            double averageAmount = score;
            result.add(new Label(pupil.name(), averageAmount));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            result.add(new Label(m.getKey(), (double) m.getValue()));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
