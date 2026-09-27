package org.example;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<String> completedTasks = new ArrayList<>();

    public void add(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty.");
        }

        task = task.trim();
        if (tasks.contains(task)) {
            throw new IllegalArgumentException("Task already exists.");
        } else {
            tasks.add(task);
        }
    }

    public void complete(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty.");
        }

        task = task.trim();
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task not found.");
        } else if (completedTasks.contains(task)) {
            throw new IllegalArgumentException("That task is already complete.");
        } else {
            completedTasks.add(task);
        }
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("The todo list is empty.");
            return;
        }

        for (String task : tasks) {
            if (completedTasks.contains(task)) {
                System.out.println("[X] " + task);
            } else {
                System.out.println("[ ] " + task);
            }
        }
    }

    public void complete() {
        if (completedTasks.isEmpty()) {
            System.out.println("There are no completed tasks.");
            return;
        }

        for (String task : tasks) {
            if (completedTasks.contains(task)) {
                System.out.println(task);
            }
        }
    }

    public void incomplete() {
        if (tasks.size() == completedTasks.size()) {
            System.out.println("There are no incomplete tasks.");
            return;
        }

        for (String task : tasks) {
            if (!completedTasks.contains(task)) {
                System.out.println(task);
            }
        }
    }

    public void clear() {
        tasks.clear();
        completedTasks.clear();
    }
}
