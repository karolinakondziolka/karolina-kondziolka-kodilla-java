package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskList {
    List<String> tasks;
    String task;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;

    }

    public void addTasks(String task) {
        tasks.add(task);

    }

    public String showTasksList(int index) {
        return tasks.get(index);
    }
}
