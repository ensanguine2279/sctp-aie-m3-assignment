package sg.edu.ntu.taskflow_api.repository;

import sg.edu.ntu.taskflow_api.model.Task;
import sg.edu.ntu.taskflow_api.model.TaskPriority;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {
    // Atomic counter for generating unique task IDs
    private static AtomicLong nextId = new AtomicLong(1);

    // In-memory storage for tasks
    private Map<Long, Task> tasks = new HashMap<>();

    public TaskRepository() {
        // Initialize with some sample tasks
        Task task1 = new Task(
                "Refactor task manager service",
                "Team has decide to code to an interface for the service component.",
                TaskPriority.MEDIUM, false);
        Task task2 = new Task(
                "Resolve bug in authentication module",
                "Unexpected error occurs when user tries to login with valid credentials.",
                TaskPriority.HIGH, false);
        Task task3 = new Task(
                "Update project documentation",
                "Ensure that the project documentation is up-to-date with the latest changes.",
                TaskPriority.LOW, false);
        Task task4 = new Task(
                "Backlog grooming",
                "Review and prioritize tasks in the backlog for the upcoming sprint.",
                TaskPriority.MEDIUM, false);
        Task task5 = new Task(
                "Migrate database to new server",
                "Move the existing database to a new server for better performance and scalability.",
                TaskPriority.HIGH, false);

        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);
        tasks.put(task4.getId(), task4);
        // tasks.put(task5.getId(), task5);
    }

    public static long getNextId() {
        return nextId.getAndIncrement();
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task findById(long id) {
        return tasks.get(id);
    }

    public boolean existsById(long id) {
        return tasks.containsKey(id);
    }

    public void create(Task task) {
        // Generate a unique ID for the new task using the atomic counter
        long id = nextId.getAndIncrement();

        task.setId(id);
        tasks.put(id, task);
    }

    public void update(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteById(long id) {
        tasks.remove(id);
    }
}
