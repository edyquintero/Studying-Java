package ToDoList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    List<Task> tasks = new ArrayList<Task>();

    public boolean addTask(Task task) {
        if (tasks.contains(task)) {
            return false;
        } else {
            tasks.add(task);
            return true;
        }
    }

    public boolean markAsCompleted(String description) {
        return tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .findFirst()
                .map(task -> { task.setDone(true); return true; })
                .orElse(false);
    }

    public boolean removeTask(String description) {
        if (tasks.stream().anyMatch(task -> task.getDescription().equals(description))) {
            tasks.removeIf(task -> task.getDescription().equals(description));
            return true;
        } else {
            return false;
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getPendingTasks() {
        return tasks.stream().filter(task -> !task.isDone()).collect(Collectors.toList());
    }
}
