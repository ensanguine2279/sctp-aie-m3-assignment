package sg.edu.ntu.taskflow_api.service;

import java.util.List;

import sg.edu.ntu.taskflow_api.exception.TaskNotFoundException;
import sg.edu.ntu.taskflow_api.model.Task;

public interface TaskService {
    List<Task> findAllTasks();

    Task findTaskById(long id) throws TaskNotFoundException;

    void createTask(Task task);

    void markTaskAsCompleted(long id) throws TaskNotFoundException;

    Task updateTask(long id, Task task) throws TaskNotFoundException;

    void deleteTask(long id) throws TaskNotFoundException;
}
