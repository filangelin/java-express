package org.example.practice12.Task3;

public class StudentGrade<T extends Number> {
    private String student;
    private String subject;
    private T value;

    public StudentGrade(String student, String subject, T grade) {
        this.student = student;
        this.subject = subject;
        this.value = grade;
    }

    public String getStudent() {
        return student;
    }

    public String getSubject() {
        return subject;
    }

    public T getValue() {
        return value;
    }
}
