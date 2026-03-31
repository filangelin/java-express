package org.example.practice12.Task3;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {
    private final List<StudentGrade<T>> grades = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> grade) {
        if (grade.getValue().doubleValue() < 0) throw new InvalidGradeException("Оценка не может быть отрицательной!");
        grades.add(grade);
    }

    public synchronized double getAverage(String subject) {
        return grades.stream()
                .filter(grade -> subject.equals(grade.getSubject()))
                .mapToDouble(grade -> grade.getValue().doubleValue())
                .average()
                .orElse(0);
    }

    public synchronized List<StudentGrade<T>> getGrades() {
        return List.copyOf(grades);
    }
}
