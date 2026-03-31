package org.example.practice12.Task6;

import java.time.LocalDate;

public class Task<T> {
    private T id;
    private String status;
    private String prioriy;
    private LocalDate date;

    public Task(T id, String status, String prioriy, LocalDate date) {
        this.id = id;
        this.status = status;
        this.prioriy = prioriy;
        this.date = date;
    }

    public T getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getPrioriy() {
        return prioriy;
    }

    public LocalDate getDate() {
        return date;
    }
}
