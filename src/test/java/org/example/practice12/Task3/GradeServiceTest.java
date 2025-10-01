package org.example.practice12.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GradeServiceTest {
    private GradeService<Number> grades;

    @BeforeEach
    public void setup() {
        grades = new GradeService<>();
    }

    public static Stream<Arguments> gradesForAdding() {
        return Stream.of(
                //int
                Arguments.of(30),
                //double
                Arguments.of(50.50)
        );
    }

    @ParameterizedTest
    @MethodSource("gradesForAdding")
    public void shouldAddValidGrades(Number gradeValue) {
        StudentGrade<Number> grade = new StudentGrade<>("Petr", "Math", gradeValue);
        grades.addGrade(grade);
        boolean containsGrade = grades.getGrades().contains(grade);
        assertAll(
                () -> assertTrue(containsGrade),
                () -> assertDoesNotThrow(() -> grades.addGrade(grade))
        );

    }

    @Test
    public void shouldThrowInvalidGradeExceptionWithNegativeNumber() {
        StudentGrade<Number> grade = new StudentGrade<>("Petr", "Math", -44);
        assertThrows(InvalidGradeException.class, () -> grades.addGrade(grade));

    }

    @Test
    public void shouldCalcCorrectAverageWithValidValues() {
        StudentGrade<Number> grade = new StudentGrade<>("Petr", "Math", 60);
        StudentGrade<Number> grade2 = new StudentGrade<>("Semen", "Math", 40);
        StudentGrade<Number> grade3 = new StudentGrade<>("Petr", "Biology", 20);
        grades.addGrade(grade);
        grades.addGrade(grade2);
        grades.addGrade(grade3);
        assertEquals(50.0, grades.getAverage("Math"));
    }

    @Test
    public void shouldReturnZeroAvgIfNoGradesBySubject() {
        StudentGrade<Number> grade = new StudentGrade<>("Petr", "Math", 60);
        StudentGrade<Number> grade2 = new StudentGrade<>("Petr", "Math", 40);
        grades.addGrade(grade);
        grades.addGrade(grade2);
        assertEquals(0.0, grades.getAverage("Biology"));

    }

}