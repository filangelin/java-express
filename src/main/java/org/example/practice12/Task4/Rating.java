package org.example.practice12.Task4;

public class Rating<T extends Number> {
    private final T value;

    public Rating(T value) {
        this.value = value;
    }

    public double getValue() {
        return value.doubleValue();
    }

}
