package org.example.practice12.Task4;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MovieService {
    private Map<Movie, List<Rating>> ratings = new ConcurrentHashMap<>();

    public void addRating(Movie movie, Rating rating) {
        if (rating.getValue() < 1 || rating.getValue() > 10)
            throw new IllegalArgumentException("Оценка должна быть в пределах от 1 до 10!");
        if (ratings.containsKey(movie)) {
            ratings.get(movie).add(rating);
        } else {
            ratings.put(movie, new ArrayList<>(List.of(rating)));
        }
    }

    public double getAverageRating(Movie movie) {
        return ratings.getOrDefault(movie, List.of()).stream()
                .map(rating -> rating.getValue())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public Map<Movie, Double> getSortedMoviesByRating() {
        return ratings.keySet().stream()
                .sorted(Comparator.comparing(this::getAverageRating).reversed())
                .collect(Collectors.toMap(ratings -> ratings,
                        this::getAverageRating,
                        (v1, v2) -> v1,
                        LinkedHashMap::new));
    }

    public List<Rating> getRatings(Movie movie) {
        return new ArrayList<>(ratings.getOrDefault(movie, List.of()));
    }


}
