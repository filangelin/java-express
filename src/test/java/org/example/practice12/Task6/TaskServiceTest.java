package org.example.practice12.Task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;
    private Task<String> task;

    @BeforeEach
    public void setup() {
        taskService = new TaskService();
        task = new Task<>("1", "new", "high", LocalDate.of(2026, 10, 1));
    }

/*
    Фильтрации:
     - приоритет
     - статус
    Сортировка по дате
     */

    @Test
    public void shouldAddTask() {
        var initialSize = taskService.getTasks().size();
        taskService.addTask(task);
        assertEquals(initialSize + 1, taskService.getTasks().size());
    }

    @Test
    public void shouldThrowExceptionWhenAddExistingId() {
        taskService.addTask(task);
        var task2 = new Task<>("1", "done", "low", LocalDate.of(2026, 10, 1));
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void shouldRemoveTask() {
        taskService.addTask(task);
        taskService.removeTask("1");
        assertTrue(taskService.getTasks().isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenRemoveNonExistingId() {
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> taskService.removeTask("2"));
    }

    @Test
    public void shouldFilterByStatus() {
        var task2 = new Task<>("2", "done", "low", LocalDate.of(2024, 10, 1));
        var task3 = new Task<>("3", "new", "low", LocalDate.of(2025, 12, 1));
        taskService.addTask(task);
        taskService.addTask(task2);
        taskService.addTask(task3);
        List<Task> filterdTasksByStatus = taskService.filterByStatus("new");
        assertAll(
                () -> assertEquals(2, filterdTasksByStatus.size()),
                () -> assertTrue(filterdTasksByStatus.stream()
                        .map(t -> t.getStatus())
                        .allMatch(t -> t.equals("new")))
        );
    }

    @Test
    public void shouldFilterByPriority() {
        var task2 = new Task<>("2", "done", "low", LocalDate.of(2024, 10, 1));
        var task3 = new Task<>("3", "new", "high", LocalDate.of(2025, 12, 1));
        taskService.addTask(task);
        taskService.addTask(task2);
        taskService.addTask(task3);
        List<Task> filterdTasksByPriority = taskService.filterByPriopity("high");
        assertAll(
                () -> assertEquals(2, filterdTasksByPriority.size()),
                () -> assertTrue(filterdTasksByPriority.stream()
                        .map(t -> t.getPrioriy())
                        .allMatch(t -> t.equals("high")))
        );
    }

    @Test
    public void shouldSortByDate() {
        var date1 = LocalDate.of(2026, 10, 1);
        var date2 = LocalDate.of(2024, 10, 1);
        var date3 = LocalDate.of(2025, 12, 1);
        var task2 = new Task<>("2", "done", "low", date2);
        var task3 = new Task<>("3", "new", "high", date3);
        taskService.addTask(task);
        taskService.addTask(task2);
        taskService.addTask(task3);
        List<Task> sortefTasksByDate = taskService.sortByDate();
        assertAll(
                () -> assertEquals(date2, sortefTasksByDate.getFirst().getDate()),
                () -> assertEquals(date3, sortefTasksByDate.get(1).getDate()),
                () -> assertEquals(date1, sortefTasksByDate.getLast().getDate())
        );


    }


}