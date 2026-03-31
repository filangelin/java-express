package org.example.practice12.Task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    private MovieService service;
    private Movie movie;


    @BeforeEach
    public void setup() {
        service = new MovieService();
        movie = new Movie("Alived");
    }

    private static Stream<Arguments> numbersForRating() {
        return Stream.of(
                //int
                Arguments.of(1),
                //double
                Arguments.of(10.0)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersForRating")
    public void shouldAddNumericRatings(Number value) {
        service.addRating(movie, new Rating<>(value));
        var actualRatings = service.getRatings(movie);
        assertEquals(1, actualRatings.size());
    }

    @Test
    public void shouldAddRatingToExistingInMapMovie() {
        service.addRating(movie, new Rating<>(1));
        service.addRating(movie, new Rating<>(10));
        var actualRatings = service.getRatings(movie);
        assertEquals(2, actualRatings.size());
    }

    private static Stream<Arguments> numbersForExceptionCatch() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(0.99),
                Arguments.of(10.01)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersForExceptionCatch")
    public void shouldThrowExceptionWithIllegalRating(Number value) {
        assertThrows(IllegalArgumentException.class, () -> service.addRating(movie, new Rating<>(value)));
    }

    @Test
    public void shouldCalcAverageRating() {
        service.addRating(movie, new Rating<>(5));
        service.addRating(movie, new Rating<>(10));
        var actualAvgRating = service.getAverageRating(movie);
        assertEquals(7.5, actualAvgRating);
    }

    @Test
    public void shouldReturnZeroAverageRatingForNonExistingMovie() {
        service.addRating(movie, new Rating<>(5));
        service.addRating(movie, new Rating<>(10));
        var newMovie = new Movie("Walking deads");
        var actualAvgRating = service.getAverageRating(newMovie);
        assertEquals(0.0, actualAvgRating);
    }

    @Test
    public void shouldSortMoviesByRatingDesc() {
        var movie2 = new Movie("Walking deads");
        service.addRating(movie2, new Rating<>(9));
        service.addRating(movie2, new Rating<>(9));

        var movie3 = new Movie("Gone");
        service.addRating(movie3, new Rating<>(2));
        service.addRating(movie3, new Rating<>(2));

        service.addRating(movie, new Rating<>(10));
        service.addRating(movie, new Rating<>(10));

        var expectedSortedMovies = new LinkedHashMap<>();
        expectedSortedMovies.put(movie, 10.0);
        expectedSortedMovies.put(movie2, 9.0);
        expectedSortedMovies.put(movie3, 2.0);
        var actualSortedMovies = service.getSortedMoviesByRating();
        assertEquals(expectedSortedMovies.entrySet(), actualSortedMovies.entrySet());
    }


}