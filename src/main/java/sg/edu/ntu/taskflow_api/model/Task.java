package sg.edu.ntu.taskflow_api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import sg.edu.ntu.taskflow_api.repository.TaskRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "title", "description", "priority", "completed" })
public class Task {
    private long id;
    private String title;
    private String description;
    private TaskPriority priority;
    private boolean completed;

    // Constructor for creating a task with a unique ID generated automatically
    public Task(String title, String description, TaskPriority priority, boolean completed) {
        this.id = TaskRepository.getNextId();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    // Constructor for creating a task with priority as a string
    public Task(String title, String description, String priority, boolean completed) {
        this(title, description, TaskPriority.valueOf(priority), completed);
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    // Sets the priority of the task using a string representation of the priority
    // enum
    public void setPriority(String priority) {
        this.priority = TaskPriority.valueOf(priority);
    }
}
