package org.example.practice12.Task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService<T> {
    private List<Task<T>> tasks = new ArrayList<>();

    public synchronized void addTask(Task<T> task) {
        if (tasks.stream()
                .map(tTask -> tTask.getId())
                .anyMatch(t -> t.equals(task.getId()))) {
            throw new IllegalArgumentException("задача с таким Id уже существует");
        }
        tasks.add(task);
    }

    public synchronized void removeTask(T id) {
        Task forRemove = tasks.stream()
                .filter(tTask -> tTask.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Нет задачи с таким Id"));
        tasks.remove(forRemove);
    }

    public synchronized List<Task> filterByStatus(String status) {
        return tasks.stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public synchronized List<Task> filterByPriopity(String priority) {
        return tasks.stream()
                .filter(task -> task.getPrioriy().equals(priority))
                .collect(Collectors.toList());
    }


    public synchronized List<Task> sortByDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(task -> task.getDate()))
                .collect(Collectors.toList());
    }

    public List<Task<T>> getTasks() {
        return tasks;
    }
}
